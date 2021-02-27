package tk.exchangeservice.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tk.exchangeservice.clients.GiphyClient;
import tk.exchangeservice.dto.giphy.GiphyRandomGifResponse;

import java.net.URI;

/**
 * * @author Andrey Fyodorov
 * * Created on 06.02.2021.
 */

@Service
public class GiphyService {
  private final Logger logger = LoggerFactory.getLogger(GiphyService.class);
	private GiphyClient giphyClient;
	@Value("${giphy.appId}")
	private String apiId;
	@Value("${giphy.broke}")
	private String BROKE;
	@Value("${giphy.rich}")
	private String RICH;

	@Autowired
	public void setGiphyClient(GiphyClient giphyClient) {
		this.giphyClient = giphyClient;
	}

	public URI getGif(String tag) {
		if (!tag.equals(BROKE) && !tag.equals(RICH)) {
		  logger.error("Unresolved [{}: Unknown gif tag in 'getGif' method]", GiphyService.class);
		  throw new IllegalArgumentException();
		}
		GiphyRandomGifResponse response = giphyClient.getRandomGif(apiId, tag);
		String uriReplaced = response.getData().getImageOriginalUrl().replaceFirst("media\\p{N}", "i");
		return URI.create(uriReplaced);
	}
}
