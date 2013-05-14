package com.practice.java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
	
public class BusinessPreClose {

	static SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

	public static void main(String[] args) throws Exception {
		System.out.println("SYDNEY:" + isPreClose(new Date().getTime(), "SYDNEY"));
		System.out.println("APAC:" + isPreClose(new Date().getTime(), "APAC"));
		System.out.println("AMER:" + isPreClose(new Date().getTime(), "AMER"));
		System.out.println("EMEA:" + isPreClose(new Date().getTime(), "EMEA"));

	}
		

	static private boolean isPreClose(long activationTimestamp, String location) throws Exception {

		Integer preCloseTime = (preCloseTimeInfo != null) ? preCloseTimeInfo.get(location) : null;
		if (preCloseTime == null) {
			return false;
		}


		int preCloseHour = preCloseTime / 100;
		int preCloseMin = preCloseTime % 100;

		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, preCloseHour);
		cal.set(Calendar.MINUTE, preCloseMin);

		if (activationTimestamp <= cal.getTimeInMillis()) {
			return true;
		}
		return false;
	}

	static Map<String, Integer> preCloseTimeInfo = new HashMap<String, Integer>();;
	static {
		preCloseTimeInfo.put("SYDNEY", 700);
		preCloseTimeInfo.put("APAC", 900);
		preCloseTimeInfo.put("AMER", 2200);
		preCloseTimeInfo.put("EMEA", 1700);
	}
}
