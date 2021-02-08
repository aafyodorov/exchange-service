package tk.exchangeservice.exceptionsAndHandlers;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * * @author Andrey Fyodorov
 * * Created on 08.02.2021.
 */

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = {
		GiphyClientRuntimeException.class,
		OpenExchangeRatesClientRuntimeException.class
	})
	protected ResponseEntity<Object> handleFeignClientExceptions(RuntimeException ex, WebRequest request) {
	  int status;
	  JSONObject body = new JSONObject();
	  HttpHeaders headers = new HttpHeaders();

	  headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
	  JSONObject jsonObject = new JSONObject(ex.getMessage());
	  if (ex instanceof OpenExchangeRatesClientRuntimeException) {
	    body.put("message", jsonObject.get("description"));
	    status = jsonObject.getInt("status");
	  } else {
		body.put("message", jsonObject.getString("message"));
		status = 401;
	  }
	  return handleExceptionInternal(ex, body.toString(), headers, HttpStatus.valueOf(status), request);
	}

  @Override
  protected @NotNull ResponseEntity<Object> handleMissingServletRequestParameter(
	  @NotNull MissingServletRequestParameterException ex,
	  HttpHeaders headers,
	  @NotNull HttpStatus status,
	  @NotNull WebRequest request) {
	JSONObject body = new JSONObject();
	headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
	body.put("message", "Required parameter 'cur' is not present");
	return handleExceptionInternal(ex, body.toString(), headers, status, request);
  }

  @ExceptionHandler(value = {UnknownCurrencyCodeException.class})
  protected ResponseEntity<Object> servicesExceptions(RuntimeException ex, WebRequest request) {
	JSONObject body = new JSONObject();
	HttpHeaders headers = new HttpHeaders();

	headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
	body.put("message", "The currency code must be three letters long. The list of currencies is available here: " +
		"https://docs.openexchangerates.org/docs/supported-currencies");
	return handleExceptionInternal(ex, body.toString(), headers, HttpStatus.BAD_REQUEST, request);
  }
}