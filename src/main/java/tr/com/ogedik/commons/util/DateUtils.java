package tr.com.ogedik.commons.util;

import tr.com.ogedik.commons.expection.ErrorException;
import tr.com.ogedik.commons.expection.constants.CommonErrorType;
import tr.com.ogedik.commons.rest.response.model.WorklogRecord;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat worklogDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    private static final SimpleDateFormat calendarDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public static Date convertWorklogDateString(String worklogDate) {
        try {
            return worklogDateFormat.parse(worklogDate);
        } catch (ParseException e) {
            throw new ErrorException(CommonErrorType.INTERNAL_ERROR, "Date string cannot be parsed to Date object");
        }
    }
    public static Date convertCalendarDateString(String calendarDate) {
        try {
            return calendarDateFormat.parse(calendarDate);
        } catch (ParseException e) {
            throw new ErrorException(CommonErrorType.INTERNAL_ERROR, "Date string cannot be parsed to Date object");
        }
    }

    public static boolean isBetween(WorklogRecord worklogRecord, String startDate, String endDate) {
        Date min = convertCalendarDateString(startDate + "T00:00:00");
        Date max = convertCalendarDateString(endDate + "T23:59:59");
        Date started = convertWorklogDateString(worklogRecord.getStarted());

        return started.after(min) && started.before(max);
    }
}
