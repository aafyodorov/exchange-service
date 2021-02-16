package tk.exchangeservice.clients;

import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.exchangeservice.exceptionsAndHandlers.GiphyClientRuntimeException;
import tk.exchangeservice.exceptionsAndHandlers.OpenExchangeRatesClientRuntimeException;

/**
 * * @author Andrey Fyodorov
 * * Created on 08.02.2021.
 */

@Configuration
public class FeignClientsConfig {
  Logger logger = LoggerFactory.getLogger(FeignClientsConfig.class);
	@Bean("feignClientErrorDecoder")
	ErrorDecoder decoder() {
	  return (s, response) -> {
	    String classKey = s.split("#")[0];
		  return switch (classKey) {
			case "GiphyClient" -> new GiphyClientRuntimeException(response.body().toString());
			case "OpenExchangeRatesClient" -> new OpenExchangeRatesClientRuntimeException(response.body().toString());
			default -> {
			  logger.error("Unresolved [{}: Unknown error. Response body: {}]",
				  FeignClientsConfig.class ,response.body());
			  throw new IllegalArgumentException();
			}
		  };
		};
	}
}
