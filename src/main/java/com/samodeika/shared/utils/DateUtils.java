package com.samodeika.shared.utils;

import com.google.gwt.i18n.client.DateTimeFormat;

import java.util.Date;

public class DateUtils {

    private static final String DATE_MASK = "dd/MM/yyyy";

    public static String getDate(Date date) {
        DateTimeFormat dtf = DateTimeFormat.getFormat(DATE_MASK);
        String dateString = dtf.format(date);
        return dateString;
    }

    public static Date getDate(String s) {
        DateTimeFormat dtf = DateTimeFormat.getFormat(DATE_MASK);
        Date date = dtf.parse(s);
        return date;
    }

    public static String getCurrentDate() {
        Date date = new Date();
        DateTimeFormat dtf = DateTimeFormat.getFormat(DATE_MASK);
        return dtf.format(date);
    }

}
