package com.bala.osp.enrolmentauth.util;

import java.util.Calendar;
import java.util.Date;

public class CommonUtils {

	public static Date today() {
		Calendar c = Calendar.getInstance(); 
		return c.getTime();
	}
	
	public static Date addDays(int n) {
		Calendar c = Calendar.getInstance(); 
		c.setTime(today()); 
		c.add(Calendar.DATE, n);
		return c.getTime();
	}
}
