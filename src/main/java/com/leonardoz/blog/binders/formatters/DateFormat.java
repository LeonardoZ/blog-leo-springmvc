package com.leonardoz.blog.binders.formatters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormat implements Formatter<Date> {
	
	public static final String PATTERN = "dd/MM/yyyy";

	@Override
	public String print(Date object, Locale locale) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
		return sdf.format(object);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
		return sdf.parse(text);
	}

}
