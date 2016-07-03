package com.toy.envmodel.observations;

import java.util.Date;


public class ObservationInfo {

	private long observedDaysInitial;
	private long generatedDaysAfterStart;
	
	private Date observationEndDate;
	private Date generationEndDate;
	/**
	 * @return the observedDaysInitial
	 */
	public long getObservedDaysInitial() {
		return observedDaysInitial;
	}
	/**
	 * @param observedDaysInitial the observedDaysInitial to set
	 */
	public void setObservedDaysInitial(long observedDaysInitial) {
		this.observedDaysInitial = observedDaysInitial;
	}
	/**
	 * @return the generatedDaysAfterStart
	 */
	public long getGeneratedDaysAfterStart() {
		return generatedDaysAfterStart;
	}
	/**
	 * @param generatedDaysAfterStart the generatedDaysAfterStart to set
	 */
	public void setGeneratedDaysAfterStart(long generatedDaysAfterStart) {
		this.generatedDaysAfterStart = generatedDaysAfterStart;
	}
	/**
	 * @return the observationEndDate
	 */
	public Date getObservationEndDate() {
		return observationEndDate;
	}
	/**
	 * @param observationEndDate the observationEndDate to set
	 */
	public void setObservationEndDate(Date observationEndDate) {
		this.observationEndDate = observationEndDate;
	}
	/**
	 * @return the generationEndDate
	 */
	public Date getGenerationEndDate() {
		return generationEndDate;
	}
	/**
	 * @param generationEndDate the generationEndDate to set
	 */
	public void setGenerationEndDate(Date generationEndDate) {
		this.generationEndDate = generationEndDate;
	}
	
	
}
