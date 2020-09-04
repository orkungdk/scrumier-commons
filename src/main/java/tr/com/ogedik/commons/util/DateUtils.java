package tr.com.ogedik.commons.util;

import tr.com.ogedik.commons.expection.ErrorException;
import tr.com.ogedik.commons.expection.constants.CommonErrorType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat worklogDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    public static Date convertWorklogDateString(String worklogDate) {
        try {
            return worklogDateFormat.parse(worklogDate);
        } catch (ParseException e) {
            throw new ErrorException(CommonErrorType.INTERNAL_ERROR, "Date string cannot be parsed to Date object");
        }
    }

}
