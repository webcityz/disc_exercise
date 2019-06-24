package com.dc.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimesAndDates {
	
	/**
	 * Get current time and date
	 * 
	 * @return Current time & date
	 * @author reggy
	 */
	public static String getCurrentTimeAndDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

}
