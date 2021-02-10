package tk.exchangeservice.controllers;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import tk.exchangeservice.exceptionsAndHandlers.UnknownCurrencyCodeException;
import tk.exchangeservice.model.GiphyService;
import tk.exchangeservice.model.OpenExchangeRatesService;

import java.net.URI;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class MainControllerTest {
  @Autowired
  private MockMvc mockMvc;
  @Autowired
  MainController controller;
  @MockBean
  OpenExchangeRatesService openExchangeRatesServiceMocked;
  @MockBean
  GiphyService giphyServiceMocked;

  @Test
  public void getGif_noRequiredParameter() throws Exception {
	mockMvc.perform(get("/gif")).andExpect(status().is(400));
  }

  @Test
  public void getGif_correctRedirect() throws Exception {
	String uri = "https://some-valid-url/gif.gir";
	when(giphyServiceMocked.getGif(anyString())).thenReturn(URI.create(uri));
	mockMvc.perform(get("/gif?cur=RUB"))
		.andExpect(status().is(303))
		.andExpect(header().string("Location", uri));
  }

  @Test
  public void getGif_caughtUnknownCurrencyCodeException() throws Exception {
	when(openExchangeRatesServiceMocked.isRateGrowth(anyString())).thenThrow(UnknownCurrencyCodeException.class);
	mockMvc.perform(get("/gif?cur=RUB"))
		.andExpect(status().is(400))
		.andExpect(header().string(HttpHeaders.CONTENT_TYPE, "application/json"))
		.andExpect(jsonPath("$.message", Matchers.matchesPattern("(\\p{Graph}|\\p{Space})+")));
  }


  @Test
  public void getGif_caughtMissingServletRequestParameterException() throws Exception {
	mockMvc.perform(get("/gif"))
		.andExpect(status().is4xxClientError())
		.andExpect(header().string(HttpHeaders.CONTENT_TYPE, "application/json"))
		.andExpect(jsonPath("$.message", Matchers.matchesPattern("(\\p{Graph}|\\p{Space})+")));
  }
}