package tk.exchangeservice.controllers;

import feign.FeignException;
import feign.Request;
import feign.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import tk.exchangeservice.clients.GiphyClient;
import tk.exchangeservice.clients.OpenExchangeRatesClient;
import tk.exchangeservice.model.GiphyService;
import tk.exchangeservice.model.OpenExchangeRatesService;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest
@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
@WebMvcTest(MainController.class)
public class MainControllerTestMocked {
	@Value("${giphy.rich}")
	private String RICH;
	@Value("${giphy.broke}")
	private String BROKE;
	@Value("${giphy.apiURI}")
	private String apiURI;
		@Value("${giphy.random}")
	private String random;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	MainController controller;
	@MockBean
	OpenExchangeRatesService openExchangeRatesServiceMocked;
	@MockBean
	GiphyService giphyServiceMocked;

	@Test
	public void getGif_correctRedirect() throws Exception {
		String uri = "https://some-valid-url/gif.gir";
		when(giphyServiceMocked.getGif(anyString())).thenReturn(URI.create(uri));
		mockMvc.perform(get("/gif?cur=RUB"))
			.andExpect(status().is(303))
			.andExpect(header().string("Location", uri));
	}

	@Test
	public void getGif_caughtIllegalArgumentException() throws Exception {
		when(openExchangeRatesServiceMocked.isRateGrowth(anyString())).thenThrow(IllegalArgumentException.class);
		controller.getGifUri(anyString()).getStatusCode();
		mockMvc.perform(get("/gif?cur=RUB")).andExpect(status().is(400));
	}

	@Test
	public void getGif_caughtErrorFromGiphyClient() throws Exception {
		when(openExchangeRatesServiceMocked.isRateGrowth(anyString())).thenReturn(false);

		GiphyClient client = mock(GiphyClient.class);
		//GiphyClientConfiguration listMock = mock(GiphyClientConfiguration.class);
		Throwable throwable = mock(Throwable.class);
		Exception exception = mock(Exception.class);
		JSONObject jsonObject = new JSONObject("{\"message\" : \"Mocked error msg\"}");
		jsonObject.put("source", OpenExchangeRatesClient.class.getSimpleName() +"#some method signature");
//		when(exception.getCause()).thenReturn(new Throwable(jsonObject.toString()));
//		when(throwable.getMessage()).thenReturn(jsonObject.toString());
//		when(listMock.decoder()).thenReturn((s, response) -> exception);
		HashMap<String, Collection<String>> map = new HashMap<>();
		FeignException ex = FeignException.errorStatus(
			"OpenExchangeRatesClient#getLatestRates(String,String,String)",
			//"GiphyClient#getRandomGif(String,String)",
			Response.builder()
				.status(401)
				.request(Request.create(
					Request.HttpMethod.GET,
					apiURI + random,
					map, //this field is required for construtor//
					null,
					null,
					null))
				.body("".getBytes(StandardCharsets.UTF_8))//this field is required for construtor
				.build());
		doThrow(ex).when(client).getRandomGif(anyString(),anyString());
		when(controller.getGifUri(anyString())).thenThrow(exception);
		when(exception.getCause()).thenReturn(throwable);
		mockMvc.perform(get("/gif?cur=RUB")).andDo(print());//.andExpect(status().is(401));
	}
}