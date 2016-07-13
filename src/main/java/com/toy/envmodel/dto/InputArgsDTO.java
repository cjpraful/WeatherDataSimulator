package com.toy.envmodel.dto;

import java.sql.Date;

import org.joda.time.DateTime;

/**
 * Input.java - DTO for Input data 
 * @author praful
 * 
 */

public class InputArgsDTO{

	private DateTime startDate;
	private DateTime endDate;
	/**
	 * @return the startDate
	 */
	public DateTime getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public DateTime getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
	
}
