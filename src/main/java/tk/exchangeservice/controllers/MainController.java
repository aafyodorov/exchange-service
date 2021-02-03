package tk.exchangeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tk.exchangeservice.clients.OpenExchangeRatesClient;
import tk.exchangeservice.dto.Rates;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * * @author Andrey Fyodorov
 * * Created on 02.02.2021.
 */

@Controller
@EnableFeignClients
@PropertySource("classpath:/openexchangerates.properties")
public class MainController {


	@GetMapping
	public ModelAndView getGif(@RequestParam(name = "cur") String currency) {
//		String yesterday = LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//		Rates todayRates = openExchangeRatesClient.getLatestRates(appId , base, currency);
//		Rates yesterdayRates = openExchangeRatesClient.getHistoricalRates(appId, base, currency, yesterday);
//		System.out.println(todayRates.getRates().toString());
//		System.out.println(yesterdayRates.getRates().toString());
//		return new ModelAndView("redirect:https://giphy.com/gifs/aarontaos-aaron-taos-fE4DEosv87ku6FezcY");
	}

//	@GetMapping("/error/${errno}")
}
