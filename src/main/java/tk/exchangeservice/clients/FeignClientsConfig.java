package tk.exchangeservice.clients;

import feign.codec.ErrorDecoder;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.exchangeservice.exceptionsAndHandlers.FeignClientException;

/**
 * * @author Andrey Fyodorov
 * * Created on 08.02.2021.
 */

@Configuration
public class FeignClientsConfig {
	@Bean("exchangeClientDecoder")
	ErrorDecoder decoder() {
		return (s, response) -> {
			JSONObject jsonObject = new JSONObject(response.body().toString());
			jsonObject.put("source", s);
			return new FeignClientException(jsonObject.toString());
		};
	}
}
