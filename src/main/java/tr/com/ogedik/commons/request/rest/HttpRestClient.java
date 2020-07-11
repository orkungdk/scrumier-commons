/**
 * © 2020 Copyright Amadeus Unauthorised use and disclosure strictly forbidden.
 */
package tr.com.ogedik.commons.request.rest;

import java.util.Collections;
import java.util.Objects;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import tr.com.ogedik.commons.constants.Services;
import tr.com.ogedik.commons.model.Headers;
import tr.com.ogedik.commons.request.rest.helper.RequestURLDetails;
import tr.com.ogedik.commons.response.RestResponse;

/**
 * @author orkun.gedik
 */
public class HttpRestClient {

  public static <T> RestResponse<T> doGet(RequestURLDetails requestURLDetails, @Nullable Class<T> responseType) {
    RestContainer restContainer = new RestContainer(requestURLDetails, enrichDefaultHttpHeaders()).invoke();
    ResponseEntity<T> response = exchange(restContainer, HttpMethod.GET, responseType);

    return new RestResponse<T>(response.getBody(), response.getHeaders(), response.getStatusCode(), response.getStatusCodeValue());
  }

  public static <T> RestResponse<T> doGet(RequestURLDetails requestURLDetails, HttpHeaders httpHeaders,
      @Nullable Class<T> responseType) {
    RestContainer restContainer = new RestContainer(requestURLDetails, httpHeaders).invoke();
    ResponseEntity<T> response = exchange(restContainer, HttpMethod.GET, responseType);

    return new RestResponse<T>(response.getBody(), response.getHeaders(), response.getStatusCode(), response.getStatusCodeValue());
  }

  public static <T> RestResponse<T> doPost(RequestURLDetails requestURLDetails, Object body,
      @Nullable Class<T> responseType) {
    RestContainer restContainer = new RestContainer(requestURLDetails, body, enrichDefaultHttpHeaders()).invoke();
    ResponseEntity<T> response = exchange(restContainer, HttpMethod.POST, responseType);

    return new RestResponse<T>(response.getBody(), response.getHeaders(), response.getStatusCode(), response.getStatusCodeValue());
  }

  public static <T> RestResponse<T> doPost(RequestURLDetails requestURLDetails, Object body, HttpHeaders httpHeaders,
      @Nullable Class<T> responseType) {
    RestContainer restContainer = new RestContainer(requestURLDetails, body, httpHeaders).invoke();
    ResponseEntity<T> response = exchange(restContainer, HttpMethod.POST, responseType);

    return new RestResponse<T>(response.getBody(), response.getHeaders(), response.getStatusCode(), response.getStatusCodeValue());
  }

  public static <T> ResponseEntity<T> exchange(RestContainer restContainer, @NonNull HttpMethod httpMethod,
      @Nullable Class<T> responseType) {
    return restContainer.getRestTemplate()
        .exchange(restContainer.getUrl(), httpMethod, restContainer.getRequest(), getResponseType(responseType));
  }

  private static <T> Class<T> getResponseType(@Nullable Class<T> responseType) {
    if (Objects.nonNull(responseType)) {
      return responseType;
    } else {
      return (Class<T>)String.class;
    }
  }

  public static HttpHeaders enrichDefaultHttpHeaders() {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    httpHeaders.add(Headers.REQUEST_SOURCE, Services.INTEGRATION);

    return httpHeaders;
  }
}
