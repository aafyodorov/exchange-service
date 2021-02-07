package tk.exchangeservice.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import tk.exchangeservice.clients.GiphyClient;
import tk.exchangeservice.dto.giphy.GiphyRandomGifResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GiphyServiceTest {
	private final String SUCCESS_RICH_URI = "https://stub-for-uri-rich.gif";
	private final String SUCCESS_BROKE_URI = "https://stub-for-uri-broke.gif";

	@Value("${giphy.rich}")
	private String RICH;
	@Value("${giphy.broke}")
	private String BROKE;
	@MockBean
	private GiphyClient mockGiphyClient;
	@Autowired
	private GiphyService giphyService;
	@Autowired
	private GiphyRandomGifResponse response;

	@Test
	public void getGif_CorrectRich() {
		response.getData().getImages().getDownsizedLarge().setUrl(SUCCESS_RICH_URI);
		when(mockGiphyClient.getRandomGif(anyString(), eq(RICH)))
			.thenReturn(response);
		assertThat(giphyService.getGif(RICH).toString()).isEqualTo(SUCCESS_RICH_URI);
	}

	@Test
	public void getGif_CorrectBroke() {
		response.getData().getImages().getDownsizedLarge().setUrl(SUCCESS_BROKE_URI);
		when(mockGiphyClient.getRandomGif(anyString(), eq(BROKE)))
			.thenReturn(response);
		assertThat(giphyService.getGif(BROKE).toString()).isEqualTo(SUCCESS_BROKE_URI);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getGif_incorrectTag() {
		String INCORRECT = "incorrect";
		response.getData().getImages().getDownsizedLarge().setUrl(anyString());
		when(mockGiphyClient.getRandomGif(anyString(), INCORRECT))
			.thenReturn(response);
		giphyService.getGif(INCORRECT);
	}
}