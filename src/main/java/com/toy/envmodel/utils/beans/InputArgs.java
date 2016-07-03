package com.toy.envmodel.utils.beans;

import java.io.Serializable;
import java.sql.Date;

/**
 * Input.java - JavaBean for Input date 
 * @author praful
 * 
 */

public class InputArgs implements Serializable{

	private Date startDate;
	private Date endDate;
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
