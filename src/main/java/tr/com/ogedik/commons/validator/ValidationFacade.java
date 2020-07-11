/**
 * © 2020 Copyright Amadeus Unauthorised use and disclosure strictly forbidden.
 */
package tr.com.ogedik.commons.validator;

import tr.com.ogedik.commons.model.BusinessObject;

import java.util.Arrays;

/**
 * @author orkun.gedik
 */
public abstract class ValidationFacade<T extends BusinessObject> {

  public void validate(T validationRequest, Validator<T>... validators) {
    Arrays.asList(validators).stream().forEach(validator -> validator.validate(validationRequest));
  }
}
