/**
 * © 2020 Copyright Amadeus Unauthorised use and disclosure strictly forbidden.
 */
package tr.com.ogedik.commons.validator;

import tr.com.ogedik.commons.model.BusinessObject;

/**
 * @author orkun.gedik
 */
public interface Validator<T extends BusinessObject> {

  void validate(T validationRequest);
}