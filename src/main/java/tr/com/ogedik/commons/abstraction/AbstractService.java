package tr.com.ogedik.commons.abstraction;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
}
