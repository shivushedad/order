package com.pizza.order.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.pizza.order.constants.Constants;

public final class DateUtil {
	
	private DateUtil() { }

	public static String getUTCTime(Long inpDate) {
		final SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getTimeZone(Constants.UTC));
		if (inpDate != null) {
			Date date = new Date(inpDate);
			return sdf.format(date);
		}
		return null;
	}
}
