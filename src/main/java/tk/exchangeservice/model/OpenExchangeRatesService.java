package tk.exchangeservice.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import tk.exchangeservice.clients.OpenExchangeRatesClient;
import tk.exchangeservice.dto.Rates;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * * @author Andrey Fyodorov
 * * Created on 03.02.2021.
 */

@Component
@PropertySource("classpath:/openexchangerates.properties")
public class OpenExchangeRatesService {
	private OpenExchangeRatesClient openExchangeRatesClient;
	@Value("${openexchangerates.appId}")
	private String appId;
	@Value("${openexchangerates.base}")
	private String base;

	@Autowired
	public void setRates(OpenExchangeRatesClient openExchangeRatesClient) {
		this.openExchangeRatesClient = openExchangeRatesClient;
	}

	public boolean isRateGrowth(String currency) {
		String yesterday = LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Rates todayRates = openExchangeRatesClient.getLatestRates(appId , base, currency);
		Rates yesterdayRates = openExchangeRatesClient.getHistoricalRates(appId, base, currency, yesterday);
		if (todayRates.getRates().size() == 0 || yesterdayRates.getRates().size() == 0)
			throw new IllegalArgumentException();
		Double currentRate = todayRates.getRates().get(currency);
		Double lastRate = yesterdayRates.getRates().get(currency);
		if (currentRate == null || lastRate == null)
			throw new IllegalArgumentException();
		return currentRate > lastRate;
	}
}
