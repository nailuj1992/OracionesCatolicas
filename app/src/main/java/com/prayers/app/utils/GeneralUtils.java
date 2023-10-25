package com.prayers.app.utils;

import java.util.Calendar;
import java.util.Date;

public class GeneralUtils {

    private GeneralUtils() {
    }

    public static int getDayNumberToday() {
        return getDayNumber(new Date());
    }

    public static int getDayNumber(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

}
