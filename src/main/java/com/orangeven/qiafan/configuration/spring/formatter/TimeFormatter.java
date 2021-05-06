package com.orangeven.qiafan.configuration.spring.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeFormatter implements Formatter<Date> {
    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        return new SimpleDateFormat("hh:mm").parse(s);
    }

    @Override
    public String print(Date date, Locale locale) {
        return new SimpleDateFormat("hh:mm").format(date);
    }
}
