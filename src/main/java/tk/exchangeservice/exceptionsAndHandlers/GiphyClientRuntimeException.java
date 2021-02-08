package tk.exchangeservice.exceptionsAndHandlers;

/**
 * * @author Andrey Fyodorov
 * * Created on 08.02.2021.
 */

public class GiphyClientRuntimeException extends RuntimeException {
  public GiphyClientRuntimeException(String message) {
	super(message);
  }
}
