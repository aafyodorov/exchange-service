package tk.exchangeservice.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import tk.exchangeservice.model.GiphyService;
import tk.exchangeservice.model.OpenExchangeRatesService;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class MainControllerTestMocked {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	MainController controller;

//	@MockBean
//	OpenExchangeRatesService openExchangeRatesServiceMocked;

	@MockBean
	GiphyService giphyServiceMocked;

	@Test(expected = IllegalArgumentException.class)
	public void getGif_getGifThrowIllegalArgumentException() throws Exception {
		when(giphyServiceMocked.getGif(anyString())).thenThrow(IllegalArgumentException.class);
		//controller.getGif(anyString());
		mockMvc.perform(get("/gif?cur=RUB"));
		//mockMvc.perform(get("/gif?cur=RUB")).andDo(print()).andExpect(status().is(400));
	}
}