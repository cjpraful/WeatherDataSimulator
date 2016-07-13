package com.toy.envmodel.helpers;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
			logger.error("Start Date / End Date Null");
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
		/*SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);*/
		
		
		try {
			DateTimeFormatter formatter = DateTimeFormat.forPattern(dateFormat);
			DateTime dt = formatter.parseDateTime(dateToValidate);			
			logger.debug(dt);
		
		} catch (Exception e) {
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
			logger.error("date format null");
			return false;
		}
		
    	try {
    		DateTimeFormatter formatter = DateTimeFormat.forPattern(dateFormat);
			
    		DateTime date1 = formatter.parseDateTime(startDate);
			DateTime date2 = formatter.parseDateTime(endDate);
			
			if(date1.isBefore(date2) || date1.isEqual(date2)){
				return true;
			}else{
				logger.error("Start Date "+startDate+" greater than End Date "+endDate);
				return false;
			}
		} catch (Exception e) {
			logger.error("Incorrect Date format - Expected Date format is (yyyy-MM-dd)");
			return false;
		}
	}
	

}
