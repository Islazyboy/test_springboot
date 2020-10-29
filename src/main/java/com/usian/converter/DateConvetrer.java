package com.usian.converter;

import java.text.ParseException;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.apache.commons.lang3.time.DateUtils;
public class DateConvetrer implements Converter<String, Date>{

    @Override
    public Date convert(String str) {
        String[] patterns = new String[]{
                "yyyy-MM-dd","yyyy-MM-dd hh:mm:ss","yyyy/MM/dd","yyyy/MM/dd hh:mm:ss",
                "MM-dd-yyyy","dd-MM-yyyy"};

        try {
            Date date = DateUtils.parseDate(str, patterns);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}