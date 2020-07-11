/**
 * © 2020 Copyright Amadeus Unauthorised use and disclosure strictly forbidden.
 */
package tr.com.ogedik.commons.constants;

/**
 * @author orkun.gedik
 */
public class Services {

  public static final String AUTHENTICATION = "authentication";
  public static final String CONFIGURATION = "configuration";
  public static final String INTEGRATION = "integration";
  public static final String API_GATEWAY = "api-gateway";

  /**
   * @author orkun.gedik
   */
  public static class Path {
    public static final String JIRA_AUTH = "/jira/auth";
    public static final String TEST_CONNECTION = "/jira/connect";
  }
}
