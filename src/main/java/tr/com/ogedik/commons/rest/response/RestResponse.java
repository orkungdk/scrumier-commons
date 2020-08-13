package tr.com.ogedik.commons.rest.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

/**
 * @author orkun.gedik
 */
@Getter
@Setter
@AllArgsConstructor
public class RestResponse<T> {
  private T body;
  private HttpHeaders headers;
  private HttpStatus httpStatus;
  private Integer httpStatusCode;
}
