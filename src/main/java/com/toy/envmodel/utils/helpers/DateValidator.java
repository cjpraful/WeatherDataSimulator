package com.toy.envmodel.utils.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * DateValidator.java - A class for validating Date 
 * @author praful
 * 
 */

public class DateValidator {
	public  static Logger logger = Logger.getLogger(DateValidator.class);
	
	public boolean isThisDateValid(String dateToValidate, String dateFromat){
		
		if(dateToValidate == null){
			logger.error("Date parameter null");
			return false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
		
		try {			
			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			logger.debug(date);
		
		} catch (ParseException e) {
			logger.error("Incorrect Date Format (yyyy-MM-dd)");
			return false;
		}		
		return true;
	
	}
	

}
