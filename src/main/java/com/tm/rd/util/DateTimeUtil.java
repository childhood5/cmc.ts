package com.tm.rd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateTimeUtil class
 * 
 *
 */
public final class DateTimeUtil {

	private DateTimeUtil() {
		// Default constructor.
	}

	public static Date formatStringToDate(final String date) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

}
