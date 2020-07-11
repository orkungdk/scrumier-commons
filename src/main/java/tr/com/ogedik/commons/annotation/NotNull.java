package tr.com.ogedik.commons.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author orkun.gedik
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Documented
public @interface NotNull {

    String message() default "Field cannot be null.";

}
