package tr.com.ogedik.commons.abstraction;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import tr.com.ogedik.commons.expection.ErrorException;
import tr.com.ogedik.commons.expection.constants.CommonErrorType;
import tr.com.ogedik.commons.rest.request.client.helper.RequestURLDetails;
import tr.com.ogedik.commons.rest.response.RestResponse;

import java.util.Arrays;
import java.util.Map;

/**
 * @author orkun.gedik
 */
public abstract class AbstractService {
    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient discoveryClient;

    public String getRequestUrl(String serviceName) {
        return getInstance(serviceName).getHomePageUrl();
    }

    public InstanceInfo getInstance(String serviceName) {
        return discoveryClient.getNextServerFromEureka(serviceName, false);
    }

    public RequestURLDetails generateRequestInfo(String serviceName, String path, Map<String, String> queryParams) {
        return new RequestURLDetails(getRequestUrl(serviceName), path, queryParams);
    }

    public <T> T resolve(RestResponse<T> response, HttpStatus... expectedStatuses) {
        if (expectedStatuses == null || expectedStatuses.length == 0) {
            return response.getBody();
        } else if (Arrays.asList(expectedStatuses).contains(response.getHttpStatus())) {
            return response.getBody();
        } else {
            throw new ErrorException(CommonErrorType.UNEXPECTED_STATUS_CODE,
                    String.format("Retrieved status code: %d", response.getHttpStatusCode()));
        }
    }
}
