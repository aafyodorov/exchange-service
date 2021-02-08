package tk.exchangeservice.clients;

import feign.codec.ErrorDecoder;
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
	@Bean("exchangeClientDecoder")
	ErrorDecoder decoder() {
	  return (s, response) -> {
	    String classKey = s.split("#")[0];
		  return switch (classKey) {
			case "GiphyClient" -> new GiphyClientRuntimeException(response.body().toString());
			case "OpenExchangeRatesClient" -> new OpenExchangeRatesClientRuntimeException(response.body().toString());
			default -> throw new IllegalArgumentException();
		  };
		};
	}
}
