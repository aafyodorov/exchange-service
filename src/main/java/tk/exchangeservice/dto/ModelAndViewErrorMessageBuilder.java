package tk.exchangeservice.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * * @author Andrey Fyodorov
 * * Created on 06.02.2021.
 */

@Component
@Scope(value = "prototype")
public class ModelAndViewErrorMessageBuilder {
	private String message;
	private String description;
	private int status;

	private ModelAndViewErrorMessageBuilder() {
	}

	@Bean
	ModelAndViewErrorMessageBuilder builder() {
		return new ModelAndViewErrorMessageBuilder();
	}

	public ModelAndViewErrorMessageBuilder setMessage(String message) {
		this.message = message;
		return this;
	}

	public ModelAndViewErrorMessageBuilder setDescription(String description) {
		this.description = description;
		return this;
	}

	public ModelAndViewErrorMessageBuilder setStatus(int status) {
		this.status = status;
		return this;
	}

	public ModelAndView build() {
		ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
		if (message != null) {
			modelAndView.addObject("message", message);
		}
		if (status != 0) {
			modelAndView.addObject("status", status);
		}
		if (description != null) {
			modelAndView.addObject("description", description);
		}
		return modelAndView;
	}
}
