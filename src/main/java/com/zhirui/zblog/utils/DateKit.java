package com.zhirui.zblog.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateKit {

    public static final int INTERVAL_DAY = 1;
    public static final int INTERVAL_WEEK = 2;
    public static final int INTERVAL_MONTH = 3;
    public static final int INTERVAL_YEAR = 4;
    public static final int INTERVAL_HOUR = 5;
    public static final int INTERVAL_MINUTE = 6;
    public static final int INTERVAL_SECOND = 7;
    public static final Date tempDate = new Date((new Long("-2177481952000")).longValue());

    public static String dateFormat(Date date, String dateFormat) {
        if (!StringUtils.isEmpty(dateFormat.trim())) {
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            if (date != null) {
                return format.format(date);
            }
        }

        return "";
    }

    public static Date dateFormat(String date, String dateFormat) {
        if (StringUtils.isEmpty(date.trim())
                || StringUtils.isEmpty(dateFormat.trim())
        ) {
            return null;
        } else {
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            try {
                return format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static String formatDateByUnixTime(long unixTime, String dateFormat) {
        return dateFormat(new Date(unixTime * 1000L), dateFormat);
    }

    public static long getUnixTimeLong() {
        return (long)getUnixTimeByDate(new Date());
    }

    public static int getCurrentUnixTime() {
        return getUnixTimeByDate(new Date());
    }

    public static int getUnixTimeByDate(Date date) {
        return (int)(date.getTime() / 1000L);
    }

    public static Date dateAdd(int interval, Date date, int n) {
        long time = date.getTime() / 1000L;
        switch (interval) {
            case 1:
                time += (long)(n * 86400);
                break;
            case 2:
                time += (long)(n * 604800);
                break;
            case 3:
                time += (long)(n * 2678400);
                break;
            case 4:
                time += (long)(n * 31536000);
                break;
            case 5:
                time += (long)(n * 3600);
                break;
            case 6:
                time += (long)(n * 60);
                break;
            case 7:
                time += (long)n;
        }

        Date result = new Date();
        result.setTime(time * 1000L);
        return result;
    }
}
