package tk.exchangeservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exchangeservice.dto.Rates;

/**
 * * @author Andrey Fyodorov
 * * Created on 03.02.2021.
 */

@PropertySource("classpath:/openexchangerates.properties")
@FeignClient(name = "openexchange", url = "${openexchangerates.apiURI}")
public interface OpenExchangeRatesClient {
	@GetMapping("${openexchangerates.latest}")
	Rates getLatestRates(@RequestParam(value = "app_id") String app_id,
	                     @RequestParam(value = "base") String base,
	                     @RequestParam(value = "symbols") String symbols);

	@GetMapping("${openexchangerates.historical}")
	Rates getHistoricalRates(@RequestParam(value = "app_id") String app_id,
                            @RequestParam(value = "base") String base,
							@RequestParam(value = "symbols") String symbols,
							@PathVariable(value = "date") String date);
}
