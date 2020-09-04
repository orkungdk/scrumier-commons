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
  UNEXPECTED_STATUS_CODE("Unexpected Status Code", 400);

  private String title;
  private int status;

  CommonErrorType(String title, int status) {
    this.title = title;
    this.status = status;
  }
}
