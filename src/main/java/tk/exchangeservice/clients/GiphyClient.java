package tk.exchangeservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exchangeservice.dto.giphy.GiphyRandomGifResponse;

/**
 * * @author Andrey Fyodorov
 * * Created on 06.02.2021.
 */

@FeignClient(name = "giphyClient", url = "${giphy.apiURI}", configuration = FeignClientsConfig.class)
public interface GiphyClient {
	@GetMapping("${giphy.random}")
	GiphyRandomGifResponse getRandomGif(@RequestParam(value = "api_key") String apiKey,
	                                    @RequestParam(value = "tag") String query);
}
