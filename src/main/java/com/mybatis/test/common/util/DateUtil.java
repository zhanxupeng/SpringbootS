package com.mybatis.test.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.function.UnaryOperator;

public class DateUtil {

    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String HHMMSS = "HHmmss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYYMMDDHHMM = "yyyyMMddHHmm";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
    public static final String YYYYMMDD_HH_MM_SS = "yyyyMMdd HH:mm:ss";
    public static final String YYYY1MM1DDHHMMSS_SSS = "yyyy/MM/dd:HH:mm:ss.SSS";
    public static final String YYYY1MM1DDHHMMSSSSSZZ = "yyyy/MM/dd:HH:mm:ss.SSS ZZ";
    public static final String YYYY1MM1DDHHMMSS = "yyyy/MM/dd HH:mm:ss";
    public static final String YYYY_MM_DDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DDHHMM = "yyyy-MM-dd HH:mm";
    public static final String MM_DD = "MM-dd";
    public static final String MM = "MM";
    public static final String ZERO_TIME = " 00:00:00";
    public static final int ZERO = 0;
    public static final int HOUR = 23;
    public static final int MINUTE = 59;
    public static final int SECOND = 59;
    public static final ZoneId zoneId = ZoneId.systemDefault();

    public static Date getCurrentDate() {
        return new Date();
    }

    public static Date getYesterday(Date date) {
        return getInterval(x -> x.plusDays(-1), date);
    }

    public static Date getIntervalMonth(Date date, int month) {
        return getInterval(x -> x.plusMonths(month), date);
    }

    public static Date getIntervalDay(Date date, int day) {
        return getInterval(x -> x.plusDays(day), date);
    }

    public static Date getIntervalHours(Date date, int hours) {
        return getInterval(x -> x.plusHours(hours), date);
    }

    public static Date getIntervalMinutes(Date date, int minutes) {
        return getInterval(x -> x.plusMinutes(minutes), date);
    }

    public static Date getIntervalSeconds(Date date, int seconds) {
        return getInterval(x -> x.plusSeconds(seconds), date);
    }

    public static Date convertStringToDate(String date, String format) {
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("日期转换异常： " + date, e);
        }
    }

    public static String convertDateToString(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static String getIntervalDate(Date date, String format, int days) {
        return convertDateToString(getIntervalDay(date, days), format);
    }

    public static String getIntervalMinute(Date date, String format, int minutes) {
        return convertDateToString(getIntervalMinutes(date, minutes), format);
    }

    public static Date getStartTimeOfSpecifiedDate(Date date) {
        return getInterval(x -> x.withHour(ZERO).withSecond(ZERO).withMinute(ZERO).withNano(ZERO), date);
    }

    public static Date getEndTimeOfSpecifiedDate(Date date) {
        return getInterval(x -> x.withHour(HOUR).withSecond(SECOND).withMinute(MINUTE), date);
    }

    public static Date getFirstDayOfMonth(Date date) {
        return getStartTimeOfSpecifiedDate(getInterval(x -> x.withDayOfMonth(1), date));
    }

    public static Date getFirstDayOfYear(Date date) {
        return getStartTimeOfSpecifiedDate(getInterval(x -> x.withDayOfYear(1), date));
    }


    public static int getBetweenDays(Date startDate, Date endDate) {
        Duration duration = Duration.between(getLocalDateTime(startDate), getLocalDateTime(endDate));
        return (int) duration.toDays();
    }

    private static LocalDateTime getLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    private static Date getInterval(UnaryOperator<LocalDateTime> unaryOperator, Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        localDateTime = unaryOperator.apply(localDateTime);
        return new Date(localDateTime.atZone(zoneId).toInstant().toEpochMilli());
    }
}
