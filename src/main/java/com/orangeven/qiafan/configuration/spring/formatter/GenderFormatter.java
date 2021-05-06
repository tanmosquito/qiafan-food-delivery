package com.orangeven.qiafan.configuration.spring.formatter;

import com.orangeven.qiafan.app.common.enumeration.Gender;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class GenderFormatter implements Formatter<Gender> {
    @Override
    public Gender parse(String s, Locale locale) throws ParseException {
        return Gender.valueOf(s);
    }

    @Override
    public String print(Gender gender, Locale locale) {
        return gender.toString();
    }
}
