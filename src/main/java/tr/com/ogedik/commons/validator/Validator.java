package tr.com.ogedik.commons.validator;

import tr.com.ogedik.commons.model.BusinessObject;

/**
 * @author orkun.gedik
 */
public interface Validator<T extends BusinessObject> {

  void validate(T validationRequest);
}