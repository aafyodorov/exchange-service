package tk.exchangeservice.exceptionsAndHandlers;

/**
 * * @author Andrey Fyodorov
 * * Created on 08.02.2021.
 */

public class OpenExchangeRatesClientRuntimeException extends RuntimeException{
  public OpenExchangeRatesClientRuntimeException(String message) {
	super(message);
  }
}
