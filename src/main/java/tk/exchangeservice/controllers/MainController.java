package tk.exchangeservice.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import tk.exchangeservice.model.OpenExchangeRatesService;

/**
 * * @author Andrey Fyodorov
 * * Created on 02.02.2021.
 */

@Controller
@EnableFeignClients
public class MainController {
	private OpenExchangeRatesService ratesService;

	@Autowired
	public void setRatesService(OpenExchangeRatesService ratesService) {
		this.ratesService = ratesService;
	}

	@GetMapping
	public ModelAndView getGif(@RequestParam(name = "cur") String currency) {
		try {
			if (ratesService.isRateGrowth(currency)) {
				return new ModelAndView("redirect:https://media2.giphy.com/media/lptjRBxFKCJmFoibP3/giphy.gif?cid=ecf05e47ah83n7upu2c6kojzn5f3lzj39z822ad5sxln5z4u&rid=giphy.gif");
			} else {
				return new ModelAndView("redirect:https://media4.giphy.com/media/1ppudqsvJAWPa63iLU/giphy.gif?cid=ecf05e47dtlpm2zhyumg1nfjpgo8bwrsmyoi621om659cf6f&rid=giphy.gif");
			}
		} catch (IllegalArgumentException ex) {
			ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
			mav.addObject("status", "400");
			mav.addObject("message", "invalid_currency_code");
			mav.addObject("description", "The currency code must be three letters long." +
				"The list of currencies is available here: https://docs.openexchangerates" +
				".org/docs/supported-currencies");
			return mav;
		} catch (Exception ex) {
			JSONObject jsonObject = new JSONObject(ex.getCause().getMessage());
			ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
			mav.addObject("status", jsonObject.getInt("status"));
			mav.addObject("message", jsonObject.getString("message"));
			mav.addObject("description", jsonObject.getString("description"));
			return mav;
		}
	}
}
