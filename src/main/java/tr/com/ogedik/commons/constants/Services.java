package tr.com.ogedik.commons.constants;

/**
 * @author orkun.gedik
 */
public final class Services {

    public static final String AUTHENTICATION = "authentication";
    public static final String CONFIGURATION = "configuration";
    public static final String INTEGRATION = "integration";
    public static final String API_GATEWAY = "api-gateway";
    public static final String TIME_TRACKER = "time-tracker";

    public static class Path {

        public static final String JIRA = "/jira";
        public static final String TRACKER = "/tracker";

        // Integration paths
        public static final String JIRA_AUTH = "/jira/auth";
        public static final String TEST_CONNECTION = "/jira/connect";
        public static final String JIRA_USER = "jira/user";
        public static final String LOGGED_ISSUES = "/logged-issues";
        public static final String CREATE_LOG = "/worklog";

        // Authentication Paths
        public static final String AUTHENTICATE = "/authenticate";
        public static final String VALIDATE = "/validate";
        public static final String USERS = "/users";
        public static final String GROUPS = "/groups";
        public static final String IDENTIFIER = "/{identifier}";
        public static final String PERMISSIONS = "/permissions";
        public static final String SETUP = "/setup";
        public static final String MAIL = "/mail";

        //Retrieve Worklog Paths
        public static final String WORKLOGS = "/worklogs";
    }
}
