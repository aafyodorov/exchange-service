package tk.exchangeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exchangeservice.model.GiphyService;
import tk.exchangeservice.model.OpenExchangeRatesService;

import java.net.URI;

/**
 * * @author Andrey Fyodorov
 * * Created on 02.02.2021.
 */

@Controller
public class ExchangeController {
	private OpenExchangeRatesService ratesService;
	private GiphyService giphyService;
	@Value("${giphy.broke}")
	private String BROKE;
	@Value("${giphy.rich}")
	private String RICH;

	@Autowired
	public void setRatesService(OpenExchangeRatesService ratesService) {
		this.ratesService = ratesService;
	}

	@Autowired
	public void setGiphyClient(GiphyService giphyService) {
		this.giphyService = giphyService;
	}

	@GetMapping("/gif")
	public ResponseEntity<String> getGifUri(@RequestParam(name = "cur") String currency) {
			String gifTag;

			if (ratesService.isRateGrowth(currency)) {
				gifTag = RICH;
			} else {
				gifTag = BROKE;
			}
			URI gifUri = giphyService.getGif(gifTag);
			return ResponseEntity
				.status(303)
				.header("Location", gifUri.toString())
				.body("");
	}
}
