package com.zhirui.zblog.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateKit {

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
}
