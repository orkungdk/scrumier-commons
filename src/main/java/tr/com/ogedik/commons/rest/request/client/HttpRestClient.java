package tr.com.ogedik.commons.rest.request.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import tr.com.ogedik.commons.constants.Services;
import tr.com.ogedik.commons.constants.Headers;
import tr.com.ogedik.commons.rest.response.RestResponse;
import tr.com.ogedik.commons.rest.request.client.helper.RequestURLDetails;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * @author orkun.gedik
 */
public class HttpRestClient {

    public static <T> RestResponse<T> doGet(RequestURLDetails requestURLDetails, @Nullable Class<T> responseType) {
        RestContainer restContainer = new RestContainer(requestURLDetails, retrieveDefaultHttpHeaders()).invoke();
        ResponseEntity<T> response = exchange(restContainer, HttpMethod.GET, responseType);

        return new RestResponse<T>(response.getBody(), response.getHeaders(), response.getStatusCode(),
                response.getStatusCodeValue());
    }

    public static <T> RestResponse<T> doGet(RequestURLDetails requestURLDetails, Map<String, String> headers,
                                            @Nullable Class<T> responseType) {
        RestContainer restContainer = new RestContainer(requestURLDetails, enrichHttpHeaders(headers)).invoke();
        ResponseEntity<T> response = exchange(restContainer, HttpMethod.GET, responseType);

        return new RestResponse<T>(response.getBody(), response.getHeaders(), response.getStatusCode(),
                response.getStatusCodeValue());
    }

    public static <T> RestResponse<T> doPost(RequestURLDetails requestURLDetails, Object body,
                                             @Nullable Class<T> responseType) {
        RestContainer restContainer = new RestContainer(requestURLDetails, body, retrieveDefaultHttpHeaders()).invoke();
        ResponseEntity<T> response = exchange(restContainer, HttpMethod.POST, responseType);

        return new RestResponse<T>(response.getBody(), response.getHeaders(), response.getStatusCode(),
                response.getStatusCodeValue());
    }

    public static <T> RestResponse<T> doPost(RequestURLDetails requestURLDetails, Object body,
                                             Map<String, String> headers, @Nullable Class<T> responseType) {
        RestContainer restContainer = new RestContainer(requestURLDetails, body, enrichHttpHeaders(headers)).invoke();
        ResponseEntity<T> response = exchange(restContainer, HttpMethod.POST, responseType);

        return new RestResponse<T>(response.getBody(), response.getHeaders(), response.getStatusCode(),
                response.getStatusCodeValue());
    }

    public static <T> ResponseEntity<T> exchange(RestContainer restContainer, @NonNull HttpMethod httpMethod,
                                                 @Nullable Class<T> responseType) {
        return restContainer.getRestTemplate().exchange(restContainer.getUrl(), httpMethod, restContainer.getRequest(),
                getResponseType(responseType));
    }

    private static <T> Class<T> getResponseType(@Nullable Class<T> responseType) {
        if (Objects.nonNull(responseType)) {
            return responseType;
        } else {
            return (Class<T>) String.class;
        }
    }

    private static HttpHeaders enrichHttpHeaders(Map<String, String> map) {
        HttpHeaders httpHeaders = retrieveDefaultHttpHeaders();
        map.forEach((key, value) -> httpHeaders.add(key, value));

        return httpHeaders;
    }

    private static HttpHeaders retrieveDefaultHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.add(Headers.REQUEST_SOURCE, Services.INTEGRATION);

        return httpHeaders;
    }
}
