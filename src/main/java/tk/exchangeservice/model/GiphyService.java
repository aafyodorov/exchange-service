package tk.exchangeservice.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import tk.exchangeservice.clients.GiphyClient;
import tk.exchangeservice.dto.giphy.GiphyRandomGifResponse;

import java.net.URI;

/**
 * * @author Andrey Fyodorov
 * * Created on 06.02.2021.
 */

@Component
public class GiphyService {
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
		if (!tag.equals(BROKE) && !tag.equals(RICH))
			throw new IllegalArgumentException();
		GiphyRandomGifResponse response = giphyClient.getRandomGif(apiId, tag);
		return URI.create(response.getData().getImages().getDownsizedLarge().getUrl());
	}
}
