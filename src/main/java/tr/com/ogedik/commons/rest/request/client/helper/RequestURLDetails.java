package tr.com.ogedik.commons.rest.request.client.helper;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
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
  private String requestPath;
  private Map<String, String> queryParameters;

  public RequestURLDetails(String homeUrl, String endpoint, Map<String, String> queryParams) {
    this.homeUrl = homeUrl;
    this.requestPath = endpoint;
    this.queryParameters = queryParams;
  }

  public String invoke() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(StringUtils.removeEnd(homeUrl, "/"));
    if (Objects.nonNull(requestPath)) {
      stringBuilder.append(requestPath.trim());
    }
    if (MapUtils.isNotEmpty(queryParameters)) {
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
        stringBuilder.append(queryParameters.get(key).trim());

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
