package tk.exchangeservice.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import tk.exchangeservice.clients.OpenExchangeRatesClient;
import tk.exchangeservice.dto.Rates;
import tk.exchangeservice.exceptionsAndHandlers.UnknownCurrencyCodeException;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OpenExchangeRatesServiceTest {

  @MockBean
  private OpenExchangeRatesClient mockOpenExchangeRatesClient;

  @Autowired
  private OpenExchangeRatesService exchangeRatesService;

  @Test
  public void isRateGrowth_TodayRateBigger() {
	String curName = "RUB";

	Rates mockTodayRates = createOneCurrencyRate(curName, 123.24);
	Rates mockHistoricalRates = createOneCurrencyRate(curName, 98.32);

	when(mockOpenExchangeRatesClient.getLatestRates(anyString(), anyString(), anyString()))
		.thenReturn(mockTodayRates);
	when(mockOpenExchangeRatesClient.getHistoricalRates(anyString(), anyString(), anyString(), anyString()))
		.thenReturn(mockHistoricalRates);

	assertThat(exchangeRatesService.isRateGrowth(curName)).isTrue();
  }

  @Test
  public void isRateGrowth_yesterdayRateBigger() {
	String curName = "RUB";

	Rates mockTodayRates = createOneCurrencyRate(curName, 54.22);
	Rates mockHistoricalRates = createOneCurrencyRate(curName, 55.03);

	when(mockOpenExchangeRatesClient.getLatestRates(anyString(), anyString(), anyString()))
		.thenReturn(mockTodayRates);
	when(mockOpenExchangeRatesClient.getHistoricalRates(anyString(), anyString(), anyString(), anyString()))
		.thenReturn(mockHistoricalRates);

	assertThat(exchangeRatesService.isRateGrowth(curName)).isFalse();
  }

  @Test(expected = UnknownCurrencyCodeException.class)
  public void isRateGrowth_wrongCurrencyCode() {
	String curName = "zzz";
	Rates mockTodayRates = new Rates();
	mockTodayRates.setRates(new HashMap<>(0));

	when(mockOpenExchangeRatesClient.getLatestRates(anyString(), anyString(), anyString()))
		.thenReturn(mockTodayRates);
	when(mockOpenExchangeRatesClient.getHistoricalRates(anyString(), anyString(), anyString(), anyString()))
		.thenReturn(mockTodayRates);

	exchangeRatesService.isRateGrowth(curName);
  }

  @Test(expected = UnknownCurrencyCodeException.class)
  public void isRateGrowth_curParameterWithoutValue() {
	String curName = "RUB";
	Rates mockTodayRates = createOneCurrencyRate(curName, null);
	Rates mockHistoricalRates = createOneCurrencyRate(curName, null);

	when(mockOpenExchangeRatesClient.getLatestRates(anyString(), anyString(), anyString()))
		.thenReturn(mockTodayRates);
	when(mockOpenExchangeRatesClient.getHistoricalRates(anyString(), anyString(), anyString(), anyString()))
		.thenReturn(mockHistoricalRates);

	exchangeRatesService.isRateGrowth(curName);
  }

  @org.jetbrains.annotations.NotNull
  private Rates createOneCurrencyRate(String currency, Double value) {
	Map<String, Double> latestRateMap = new HashMap<>();
	latestRateMap.put(currency, value);
	Rates rates = new Rates();
	rates.setRates(latestRateMap);
	return rates;
  }
}