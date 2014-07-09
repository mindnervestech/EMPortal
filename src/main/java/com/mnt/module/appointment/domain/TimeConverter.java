package com.mnt.module.appointment.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeConverter {
	 
	public static String convertElapsedMinToDayTime(int min) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm a");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.MINUTE, min);
		return dateFormat.format(new Date(cal.getTimeInMillis()));
	}
	
	public static int convertDayTimeToElapsedMin(String min) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm a");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateFormat.parse("01-01-1970 " + min +" PM"));
		return cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
	}

}
