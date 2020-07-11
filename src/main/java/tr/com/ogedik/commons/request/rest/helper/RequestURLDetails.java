/**
 * © 2020 Copyright Amadeus Unauthorised use and disclosure strictly forbidden.
 */
package tr.com.ogedik.commons.request.rest.helper;

import lombok.Getter;
import lombok.Setter;
import tr.com.ogedik.commons.annotation.NotNull;
import tr.com.ogedik.commons.expection.ErrorException;
import tr.com.ogedik.commons.expection.constants.CommonErrorType;

import java.util.Map;
import java.util.Objects;

/**
 * @author orkun.gedik
 */
@Getter
@Setter
public class RequestURLDetails implements Cloneable {
  private String homeUrl;
  private String contextPath;
  private String requestPath;
  private Map<String, String> queryParameters;

  public RequestURLDetails(String homeUrl, String contextPath, String endpoint, Map<String, String> queryParams) {
    this.homeUrl = homeUrl;
    this.contextPath = contextPath;
    this.requestPath = endpoint;
    this.queryParameters = queryParams;
  }

  public String invoke() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(homeUrl);
    if (Objects.nonNull(contextPath)) {
      stringBuilder.append("/");
      stringBuilder.append(contextPath);
    }
    if (Objects.nonNull(requestPath)) {
      stringBuilder.append(requestPath);
    }
    if (!queryParameters.isEmpty()) {
      boolean isFirstParameter = true;

      for (String key : queryParameters.keySet()) {
        if (isFirstParameter) {
          stringBuilder.append("?");
          isFirstParameter = false;
        } else {
          stringBuilder.append("&");
        }
        stringBuilder.append(key);
        stringBuilder.append("=");
        stringBuilder.append(queryParameters.get(key));

      }
    }
    return stringBuilder.toString();
  }

  @Override
  public Object clone() {
    try {
      return super.clone();
    } catch (CloneNotSupportedException e) {
      throw new ErrorException(CommonErrorType.INTERNAL_ERROR, "Request URL cannot be generated.");
    }
  }
}
