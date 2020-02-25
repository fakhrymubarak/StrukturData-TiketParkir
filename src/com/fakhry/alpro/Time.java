package com.fakhry.alpro;

import java.text.SimpleDateFormat;
import java.util.Calendar;

class Time {
    static String secToHours(int waktuTotal) {
        int months = waktuTotal / 2592000;
        int days = (waktuTotal - 2592000 * months) / 86400;
        int hours = (waktuTotal - 2592000 * months - 86400 * days) / 3600;
        int minutes = (waktuTotal - 2592000 * months - 86400 * days - 3600 * hours) / 60;
        int seconds = waktuTotal % 60;

        return months + " mth - "
                + days + " days - "
                + hours + " hrs - "
                + minutes + " mins - "
                + seconds + " secs";
    }

    static int currentTimeInSec() {
        String currentMonth = new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
        String currentDate = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
        String currentHours = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());
        String currentMinutes = new SimpleDateFormat("mm").format(Calendar.getInstance().getTime());
        String currentSecond = new SimpleDateFormat("ss").format(Calendar.getInstance().getTime());

        int totalSecond;
        totalSecond = Integer.parseInt(currentSecond)
                + Integer.parseInt(currentMinutes) * 60
                + Integer.parseInt(currentHours) * 3600
                + Integer.parseInt(currentDate) * 86400
                + Integer.parseInt(currentMonth) * 2592000;
        return totalSecond;
    }
}
