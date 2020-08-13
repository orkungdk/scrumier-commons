package tr.com.ogedik.commons.validator;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import tr.com.ogedik.commons.annotation.NotNull;
import tr.com.ogedik.commons.expection.ErrorException;
import tr.com.ogedik.commons.expection.constants.CommonErrorType;
import tr.com.ogedik.commons.expection.model.ErrorMessage;
import tr.com.ogedik.commons.model.BusinessObject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author orkun.gedik
 */
public class MandatoryFieldValidator implements Validator {

  public static MandatoryFieldValidator instance;

  private MandatoryFieldValidator() { }

  public static MandatoryFieldValidator getInstance() {
    if (instance == null) {
      instance = new MandatoryFieldValidator();
    }

    return instance;
  }

  /**
   * Validates that the required fields are not empty.
   *
   * @param object {@link BusinessObject}
   */
  @Override
  public void validate(BusinessObject object) {
    if (object == null) {
      throw new ErrorException(CommonErrorType.INVALID_INPUT, "Input value cannot be null.");
    }

    List<ErrorMessage> errorMessages = null;

    Field[] fields = object.getClass().getDeclaredFields();

    for (Field field : fields) {
      field.setAccessible(true);

      Optional<Annotation> notNullAnnotation = Arrays.stream(field.getDeclaredAnnotations())
          .filter(annotation -> annotation instanceof NotNull)
          .findFirst();

      if (notNullAnnotation.isPresent()) {
        errorMessages = retrieveMissingFieldValues(field, object, ((NotNull)notNullAnnotation.get()).message());
      }
    }

    if (CollectionUtils.isNotEmpty(errorMessages)) {
      throw new ErrorException(errorMessages);
    }
  }

  /**
   * Validates mandatory fields and returns missing fields
   *
   * @param field mandatory field to validate
   * @param object instance of an object to validate
   * @param message exception message
   */
  private List<ErrorMessage> retrieveMissingFieldValues(Field field, Object object, String message) {
    List<ErrorMessage> errorMessages = new ArrayList<>();
    Object value = getObject(field, object);

    if (ObjectUtils.isEmpty(value)) {
      ErrorMessage errorMessage = new ErrorMessage();
      errorMessage.setTitle(CommonErrorType.MISSING_FIELD_VALUE.getTitle());
      errorMessage.setStatus(CommonErrorType.MISSING_FIELD_VALUE.getStatus());
      errorMessage.setDetail(message);
      errorMessage.setPointer(field.getName());

      errorMessages.add(errorMessage);
    }

    return errorMessages;
  }

  /**
   * Returns object value from field
   *
   * @param field mandatory field to validate
   * @param object instance of an object to validate
   * @return value of the {@code field} in the given {@code object}
   * @throws ErrorException if IllegalAccessException is thrown
   */
  private Object getObject(Field field, Object object) {
    try {
      return field.get(object);
    } catch (IllegalAccessException e) {
      throw new ErrorException(e);
    }
  }
}
