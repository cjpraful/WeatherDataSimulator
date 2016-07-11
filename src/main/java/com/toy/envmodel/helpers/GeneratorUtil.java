package com.toy.envmodel.helpers;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.Random;

import org.apache.log4j.Logger;

import com.toy.envmodel.constants.ModelConstants;

/**
 * GeneratorUtil.java - Util class for Date Operation
 * @author praful
 * 
 */

public class GeneratorUtil {
	public  static Logger logger = Logger.getLogger(GeneratorUtil.class);
	static StringBuilder builder = new StringBuilder();
	static long TIME_LOWER_RANGE = 10000000; // assign lower range value
	static long TIME_UPPER_RANGE = 100000000; // assign upper range valuesssssss

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return new java.sql.Date(cal.getTimeInMillis());
	}

	public static String getTime() {

		Random random = new Random();

		long randomValue = TIME_LOWER_RANGE
				+ (long) (random.nextDouble() * (TIME_UPPER_RANGE - TIME_LOWER_RANGE));
		Time time = new Time(randomValue);
		builder.setLength(0);
		return (builder.append(ModelConstants.TIME_START).append(time)
				.append(ModelConstants.TIME_END).toString());
	}
}
