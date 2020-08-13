package tr.com.ogedik.commons.util;

import lombok.experimental.UtilityClass;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author orkun.gedik
 */
@UtilityClass
public class ObjectUtils {

  public static <T> Optional<T> getNestedObjectOfNullable(Supplier<T> resolver) {
    try {
      T result = resolver.get();
      return Optional.ofNullable(result);
    } catch (NullPointerException e) {
      return Optional.empty();
    }
  }
}
