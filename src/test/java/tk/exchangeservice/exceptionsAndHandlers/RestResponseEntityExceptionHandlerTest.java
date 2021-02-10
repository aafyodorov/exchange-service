package tk.exchangeservice.exceptionsAndHandlers;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;

public class RestResponseEntityExceptionHandlerTest {

  @Test
  public void handleFeignClientExceptions_catchOpenExchangeRatesClientRuntimeException() throws Exception {
    JSONObject jsonObject = new JSONObject();

    jsonObject.put("description", "some error msg");
    jsonObject.put("status", 400);
    OpenExchangeRatesClientRuntimeException ex = new OpenExchangeRatesClientRuntimeException(jsonObject.toString());
    RestResponseEntityExceptionHandler exceptionHandler = new RestResponseEntityExceptionHandler();
    ResponseEntity<Object> result = exceptionHandler.handleFeignClientExceptions(ex, null);
    assertEquals(result.getStatusCodeValue(), 400);
    assertTrue(result.getHeaders().get(HttpHeaders.CONTENT_TYPE).contains("application/json"));
  }

  @Test
  public void handleFeignClientExceptions_catchGiphyClientRuntimeException() throws Exception {
    JSONObject jsonObject = new JSONObject();

    jsonObject.put("message", "some error msg");
    GiphyClientRuntimeException ex = new GiphyClientRuntimeException(jsonObject.toString());
    RestResponseEntityExceptionHandler exceptionHandler = new RestResponseEntityExceptionHandler();
    ResponseEntity<Object> result = exceptionHandler.handleFeignClientExceptions(ex, null);
    assertEquals(result.getStatusCodeValue(), 401);
    assertTrue(result.getHeaders().get(HttpHeaders.CONTENT_TYPE).contains("application/json"));
  }
}