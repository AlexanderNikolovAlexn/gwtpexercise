package com.samodeika.client.utils;

import com.google.gwt.i18n.client.DateTimeFormat;

import java.util.Date;

public class DateUtils {

    private static final String DATE_MASK = "dd/MM/yyyy";

    public static String getDate(Date date) {
        String dateString = DateTimeFormat.getFormat(DATE_MASK).format(date);
        return dateString;
    }

    public static String getCurrentDate() {
        Date date = new Date();
        DateTimeFormat dtf = DateTimeFormat.getFormat(DATE_MASK);
        return dtf.format(date);
    }

}
