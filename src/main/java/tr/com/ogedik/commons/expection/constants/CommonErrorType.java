package tr.com.ogedik.commons.expection.constants;

import lombok.Getter;

/**
 * @author orkun.gedik
 */
@Getter
public enum CommonErrorType implements ErrorType {
  INTERNAL_ERROR("Internal Error", 500),
  INVALID_INPUT("Invalid Input", 400),
  MISSING_FIELD_VALUE("Missing Field Value", 400),
  DATA_ACCESS_EXCEPTION("Data Access Exception", 400),
  UNEXPECTED_STATUS_CODE("Unexpected Status Code", 400),

  JIRA_AUTHENTICATION_ERROR("Cannot authenticate the JIRA instance with the current credentials.", 401),
  JIRA_ACCESS_ERROR("JIRA instance is not accessible currently. Please contact with a system administrator", 404);

  private String title;
  private int status;

  CommonErrorType(String title, int status) {
    this.title = title;
    this.status = status;
  }
}
