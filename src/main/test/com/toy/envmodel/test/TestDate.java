package com.toy.envmodel.test;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.Random;

public class TestDate {

	
	public static void main(String[] args) {
		String date = "2016-06-29";
		Date cdate = Date.valueOf(date);
		System.out.println(addDays(cdate,2));
		System.out.println(cdate.compareTo(addDays(cdate,-1)));
		
		long LOWER_RANGE = 10000000; //assign lower range value
		 long UPPER_RANGE = 100000000; //assign upper range value
		 Random random = new Random();


		 long randomValue = LOWER_RANGE + 
		                           (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
		Time time = new Time(randomValue);
		System.out.println(time);
	}
	
	 public static Date addDays(Date date, int days)
	    {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DATE, days); //minus number would decrement the days
	        return  new java.sql.Date(cal.getTimeInMillis());
	    }
}
