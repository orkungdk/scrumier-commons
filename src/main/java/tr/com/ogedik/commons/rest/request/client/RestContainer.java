package tr.com.ogedik.commons.rest.request.client;

import lombok.Getter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import tr.com.ogedik.commons.rest.request.client.helper.RequestURLDetails;

/**
 * @author orkun.gedik
 */
@Getter
public class RestContainer {
    private RequestURLDetails requestURLDetails;
    private HttpHeaders httpHeaders;
    private RestTemplate restTemplate;
    private Object body;
    private HttpEntity request;
    private String url;

    public RestContainer(RequestURLDetails requestURLDetails, Object body, HttpHeaders httpHeaders) {
        this(requestURLDetails, httpHeaders);
        this.body = body;
    }

    public RestContainer(RequestURLDetails requestURLDetails, HttpHeaders httpHeaders) {
        this.requestURLDetails = requestURLDetails;
        this.httpHeaders = httpHeaders;
    }

    public RestContainer invoke() {
        restTemplate = new RestTemplate();
        request = new HttpEntity(body, httpHeaders);
        url = requestURLDetails.invoke();

        return this;
    }

}
