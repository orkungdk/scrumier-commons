/**
 * © 2020 Copyright Amadeus Unauthorised use and disclosure strictly forbidden.
 */
package tr.com.ogedik.commons.expection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tr.com.ogedik.commons.expection.constants.ErrorType;
import tr.com.ogedik.commons.expection.model.ErrorMessage;

/**
 * @author orkun.gedik
 */
public class ErrorException extends RuntimeException {
    private final ArrayList<ErrorMessage> errors = new ArrayList<>();
    private final int httpStatusCode;

    /**
     * Creates a basic Internal Server Error - HTTP 500
     *
     * @param cause Cause of this exception
     */
    public ErrorException(Throwable cause) {
        this((Iterable<ErrorMessage>) null, cause);
    }

    /**
     * Creates an exception from a list of errors The first HTTP status will be the HTTP status of the response
     *
     * @param errors list of errors to display
     * @param cause  Cause of this exception
     */
    public ErrorException(final Iterable<ErrorMessage> errors, Throwable cause) {
        super(cause);
        httpStatusCode = buildErrors(errors);
    }

    /**
     * Creates an exception from a list of errors The first HTTP status will be the HTTP status of the response
     *
     * @param errors list of errors to display
     */
    public ErrorException(final Iterable<ErrorMessage> errors) {
        httpStatusCode = buildErrors(errors);
    }

    /**
     * Create an exception from a single ErrorMessage
     *
     * @param error the error to display
     */
    public ErrorException(final ErrorMessage error) {
        this(Collections.singletonList(error));
    }

    /**
     * Create an exception from a single ErrorMessage
     *
     * @param details the error details to display
     */
    public ErrorException(ErrorType errorType, String details) {
        ErrorMessage error = new ErrorMessage();
        error.setTitle(errorType.getTitle());
        error.setStatus(errorType.getStatus());
        error.setDetail(details);

        httpStatusCode = buildErrors(Collections.singletonList(error));
    }

    /**
     * Create an exception from a single ErrorMessage and chains the original exception to it.
     *
     * @param error the error to display
     * @param cause the Throwable that caused this exception
     */
    public ErrorException(final ErrorMessage error, Throwable cause) {
        this(Collections.singletonList(error), cause);
    }

    private int buildErrors(Iterable<ErrorMessage> errors) {
        int tmpHttpStatusCode = 500;
        if (errors != null) {
            // Http status code is the first Exception's http status code
            if (errors.iterator().hasNext()) {
                ErrorMessage errorMessage = errors.iterator().next();
                if (errorMessage.getStatus() != null) {
                    tmpHttpStatusCode = errorMessage.getStatus();
                }
            }
            for (ErrorMessage errorMessage : errors) {
                this.errors.add(errorMessage);
            }
        }
        return tmpHttpStatusCode;
    }

    /**
     * @return the field #httpStatusCode
     **/
    public final Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    /**
     * @return the field #errors
     **/
    public final List<ErrorMessage> getErrors() {
        return errors;
    }
}
