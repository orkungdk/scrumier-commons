package tr.com.ogedik.commons.constants;

/**
 * @author orkun.gedik
 */
public final class Services {

    public static final String AUTHENTICATION = "authentication";
    public static final String CONFIGURATION = "configuration";
    public static final String INTEGRATION = "integration";
    public static final String API_GATEWAY = "api-gateway";

    public static class Path {
        // Integration paths
        public static final String JIRA_AUTH = "/jira/auth";
        public static final String TEST_CONNECTION = "/jira/connect";
        public static final String JIRA_USER = "jira/user";

        // Authentication Paths
        public static final String AUTHENTICATE = "/authenticate";
        public static final String VALIDATE = "/validate";
        public static final String USERS = "/users";
        public static final String GROUPS = "/groups";
        public static final String IDENTIFIER = "/{identifier}";
        public static final String PERMISSIONS = "/permissions";
        public static final String SETUP = "/setup";
        public static final String JIRA = "/jira";
        public static final String MAIL = "/mail";
    }
}
