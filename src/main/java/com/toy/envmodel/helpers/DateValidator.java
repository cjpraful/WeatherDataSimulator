package com.toy.envmodel.helpers;

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
	
	
	/**
	 * @param startDate 
	 * @param endDate
	 * @param dateFormat
	 * @return true if valid ,false if invalid
	 */
	public boolean isValidDates(String startDate,String endDate, String dateFormat){
		if(startDate!=null && endDate != null){
			if(isThisDateValid(startDate,dateFormat) && isThisDateValid(endDate, dateFormat)){
				if(compareDates(startDate,endDate,dateFormat)){
					return true;
				}else 
					return false;				
			}else{
				return false;
			}
		}else{
			logger.error("Start Date /End Date Null");
			return false;
		}
	}
	
	
	/**
	 * @param dateToValidate
	 * @param dateFormat
	 * @return true if valid ,false if invalid
	 */
	public boolean isThisDateValid(String dateToValidate, String dateFormat){
		
		if(dateToValidate == null){
			logger.error("Date parameter null");
			return false;
		}
		if(dateFormat == null){
			logger.error("dateFromat null");
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);
		
		try {			
			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			logger.debug(date);
		
		} catch (ParseException e) {
			logger.error("Incorrect Date "+dateToValidate +" Expected Date format is (yyyy-MM-dd)");
			return false;
		}		
		return true;
	
	}
	
	/**
	 * @param startDate
	 * @param endDate
	 * @param dateFormat
	 * @return true if endDate is greater than startDate
	 */
	public boolean compareDates(String startDate,String endDate, String dateFormat){
		if(startDate == null || endDate == null){
			logger.error("Date parameter null");
			return false;
		}
		if(dateFormat == null){
			logger.error("dateFromat null");
			return false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    	try {
			Date date1 = sdf.parse(startDate);
			Date date2 = sdf.parse(endDate);
			if(date1.compareTo(date2) <= 0){
				return true;
			}else{
				logger.error("Start Date "+startDate+" greater than End Date "+endDate);
				return false;
			}
		} catch (ParseException e) {
			logger.error("Error Parsing date "+e);
			return false;
		}
	}
	

}
