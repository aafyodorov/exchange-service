package tk.exchangeservice.exceptionsAndHandlers;

/**
 * * @author Andrey Fyodorov
 * * Created on 08.02.2021.
 */

public class FeignClientException extends RuntimeException {
	public FeignClientException(String message) {
		super(message);
	}
}
