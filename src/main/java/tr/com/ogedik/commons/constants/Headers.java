package tr.com.ogedik.commons.constants;

import lombok.experimental.UtilityClass;

/**
 * @author orkun.gedik
 */
@UtilityClass
public final class Headers {

    public static final String AUTH_TOKEN = "X-Auth-Token";
    public static final String AUTH_USER = "X-Auth-User";
    public static final String AUTHORITIES = "X-Authorities";
    public static final String REQUEST_SOURCE = "X-Request-Source";

    public static final String ANONYMOUS = "Anonymous";
    public static final String PREFIX = "Bearer ";

}
