package tr.com.ogedik.commons.annotation;

import java.lang.annotation.*;

/**
 * @author orkun.gedik
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Documented
public @interface NotNull {

    String message() default "Field cannot be null.";
}
