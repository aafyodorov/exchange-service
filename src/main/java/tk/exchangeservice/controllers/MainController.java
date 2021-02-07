package tk.exchangeservice.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tk.exchangeservice.clients.GiphyClient;
import tk.exchangeservice.clients.OpenExchangeRatesClient;
import tk.exchangeservice.dto.ModelAndViewErrorMessageBuilder;
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
	private ModelAndViewErrorMessageBuilder messageBuilder;
	@Value("${giphy.broke}")
	private String BROKE;
	@Value("${giphy.rich}")
	private String RICH;
	@Autowired
	@Qualifier(value = "builder")
	public void setMessageBuilder(ModelAndViewErrorMessageBuilder messageBuilder) {
		this.messageBuilder = messageBuilder;
	}

	@Autowired
	public void setRatesService(OpenExchangeRatesService ratesService) {
		this.ratesService = ratesService;
	}

	@Autowired
	public void setGiphyClient(GiphyService giphyService) {
		this.giphyService = giphyService;
	}

	public GiphyService getGiphyService() {
		return giphyService;
	}

	@GetMapping("/gif")
	public ModelAndView getGif(@RequestParam(name = "cur", required = false) String currency) {
		if (currency == null) {
			return messageBuilder.setStatus(400).setMessage("no_cur_parameter")
				.setDescription("Required parameter 'cur' is not present. Add").build();
		}
		try {
			String gifTag;
			if (ratesService.isRateGrowth(currency)) {
				gifTag = RICH;
			} else {
				gifTag = BROKE;
			}
			URI gifUri = giphyService.getGif(gifTag);
			return new ModelAndView("redirect:" + gifUri.toString());
		} catch (IllegalArgumentException ex) {
			messageBuilder.setStatus(400).setMessage("invalid_currency_code")
				.setDescription("The currency code must be three letters long. The list of currencies is available here:" +
					" https://docs.openexchangerates.org/docs/supported-currencies");
			return messageBuilder.build();
		} catch (Exception ex) {
			JSONObject jsonObject = new JSONObject(ex.getCause().getMessage());
			String causedClassName = jsonObject.getJSONArray("source").get(0).toString().split("#")[0];
			messageBuilder.setMessage(jsonObject.getString("message"));
			if (causedClassName.contains(OpenExchangeRatesClient.class.getSimpleName())) {
				messageBuilder.setStatus(jsonObject.getInt("status")).setDescription(jsonObject.getString(
					"description"));
			} else if (causedClassName.contains(GiphyClient.class.getSimpleName())) {
				messageBuilder.setStatus(400).setDescription(jsonObject.getString("message"));
			}
			return messageBuilder.build();
		}
	}
}
