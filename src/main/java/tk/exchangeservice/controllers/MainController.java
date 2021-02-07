package tk.exchangeservice.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tk.exchangeservice.clients.GiphyClient;
import tk.exchangeservice.clients.OpenExchangeRatesClient;
import tk.exchangeservice.model.GiphyService;
import tk.exchangeservice.model.OpenExchangeRatesService;

import java.net.URI;

/**
 * * @author Andrey Fyodorov
 * * Created on 02.02.2021.
 */

@Controller
public class MainController {
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
	public ResponseEntity<String> getGif(@RequestParam(name = "cur", required = false) String currency) {
		if (currency == null) {
			return ResponseEntity
				.status(400)
				.header("Content-Type", "application/json")
				.body("{\"message\" : \"Required parameter 'cur' is not present. Add\"}");
		}
		try {
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
		} catch (IllegalArgumentException ex) {
			return ResponseEntity
				.status(400)
				.header("Content-Type", "application/json")
				.body("{\"message\" : \"The currency code must be three letters long. The list of currencies is " +
					"available here: https://docs.openexchangerates.org/docs/supported-currencies\"}");
		} catch (Exception ex) {
			int status;
			String message;
			JSONObject body = new JSONObject();
			JSONObject jsonObject = new JSONObject(ex.getCause().getMessage());

			String causedClassName = jsonObject.getJSONArray("source").get(0).toString().split("#")[0];
			if (causedClassName.contains(OpenExchangeRatesClient.class.getSimpleName())) {
				message = jsonObject.getString("description");
				status = jsonObject.getInt("status");
			} else if (causedClassName.contains(GiphyClient.class.getSimpleName())) {
				message = jsonObject.getString("message");
				status = 401;
			} else {
				throw new UnknownError();
			}
			body.put("message", message);
			return ResponseEntity
				.status(status)
				.header("Content-Type", "application/json")
				.body(body.toString());
		}
	}
}
