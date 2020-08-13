package tr.com.ogedik.commons.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tr.com.ogedik.commons.expection.ErrorException;
import tr.com.ogedik.commons.rest.response.AbstractResponse;

/**
 * @author orkun.gedik
 */
public abstract class AbstractController {

    @ExceptionHandler
    public AbstractResponse handleError(ErrorException e) {
        return AbstractResponse.build(e.getErrors(), HttpStatus.valueOf(e.getHttpStatusCode()));
    }
}
