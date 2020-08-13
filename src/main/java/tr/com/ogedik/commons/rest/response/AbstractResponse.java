package tr.com.ogedik.commons.rest.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

/**
 * @author orkun.gedik
 */
public class AbstractResponse extends ResponseEntity {
    public AbstractResponse(HttpStatus status) {
        super(status);
    }

    public static AbstractResponse unauthorized() {
        return new AbstractResponse(HttpStatus.UNAUTHORIZED);
    }

    public static AbstractResponse OK() {
        return new AbstractResponse(HttpStatus.OK);
    }

    public static AbstractResponse KO() {
        return new AbstractResponse(HttpStatus.BAD_REQUEST);
    }

    public AbstractResponse(Object body, HttpStatus httpStatus) {
        super(body, httpStatus);
    }

    public static AbstractResponse build(Object body) {
        if (ObjectUtils.isEmpty(body)) {
            return new AbstractResponse(HttpStatus.NO_CONTENT);
        } else {
            return new AbstractResponse(body, HttpStatus.OK);
        }
    }

    public static AbstractResponse build(boolean result) {
        if (result) {
            return new AbstractResponse(HttpStatus.OK);
        } else {
            return new AbstractResponse(HttpStatus.BAD_REQUEST);
        }
    }

    public static AbstractResponse build(Object object, HttpStatus httpStatus) {
        return new AbstractResponse(object, httpStatus);
    }
}
