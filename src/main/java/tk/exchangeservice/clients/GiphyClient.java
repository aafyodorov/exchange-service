package tk.exchangeservice.clients;

import feign.codec.ErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exchangeservice.dto.giphy.GiphyRandomGifResponse;

/**
 * * @author Andrey Fyodorov
 * * Created on 06.02.2021.
 */

@PropertySource("classpath:/giphy.properties")
@FeignClient(name = "giphyClient", url = "${giphy.apiURI}", configuration = GiphyClientConfiguration.class)
public interface GiphyClient {
	@GetMapping("${giphy.random}")
	GiphyRandomGifResponse getRandomGif(@RequestParam(value = "api_key") String apiKey,
	                                    @RequestParam(value = "tag") String query);
}


@Configuration
class GiphyClientConfiguration {
	@Bean(name = "giphyClientDecoder")
	ErrorDecoder decoder() {
		return (s, response) -> new Exception(response.body().toString());
	}
}