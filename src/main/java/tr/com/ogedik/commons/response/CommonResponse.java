/**
 * © 2020 Copyright Amadeus Unauthorised use and disclosure strictly forbidden.
 */
package tr.com.ogedik.commons.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

/**
 * @author orkun.gedik
 */
public class CommonResponse extends ResponseEntity {
  public CommonResponse(HttpStatus status) {
    super(status);
  }

  public static CommonResponse unauthorized() {
    return new CommonResponse(HttpStatus.UNAUTHORIZED);
  }

  public static CommonResponse OK() {
    return new CommonResponse(HttpStatus.OK);
  }

  public static CommonResponse KO() {
    return new CommonResponse(HttpStatus.BAD_REQUEST);
  }

  private CommonResponse(Object body, HttpStatus httpStatus) {
    super(body, httpStatus);
  }

  public static CommonResponse build(Object body) {
    if (ObjectUtils.isEmpty(body)) {
      return new CommonResponse(HttpStatus.BAD_REQUEST);
    } else {
      return new CommonResponse(body, HttpStatus.OK);
    }
  }

  public static CommonResponse build(boolean result) {
    if (result) {
      return new CommonResponse(HttpStatus.OK);
    } else {
      return new CommonResponse(HttpStatus.BAD_REQUEST);
    }
  }

}
