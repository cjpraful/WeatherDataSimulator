package com.toy.envmodel.observations;

/**
 * RegionObservedParams.java - 
 * @author praful
 * 
 */

public class RegionObservedParams {
	String month;
	double meanTemperature;
	double meanPressure;
	double meanHumidity;


	//approx std deviations expected from respective avg values
	double sdTemperature;
	double sdPressure;
	double sdHumidity;

	//Condition that occurs mostly in the season/month
	String predominantCondition;
	// wetday probability if previous day is wet
	double prob_ww;
	// wetday probability if previous day is dry
	double prob_wd;
	// TODO add more pressure humidity


	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return the meanTemp
	 */
	public double getMeanTemperature() {
		return meanTemperature;
	}
	/**
	 * @param meanTemp the meanTemp to set
	 */
	public void setMeanTemperature(double meanTemperature) {
		this.meanTemperature = meanTemperature;
	}
	/**
	 * @return the sdTemp
	 */
	public double getSdTemperature() {
		return sdTemperature;
	}
	/**
	 * @param sdTemp the sdTemp to set
	 */
	public void setSdTemperature(double sdTemperature) {
		this.sdTemperature = sdTemperature;
	}
	/**
	 * @return the prob_ww
	 */
	public double getProb_ww() {
		return prob_ww;
	}
	/**
	 * @param prob_ww the prob_ww to set
	 */
	public void setProb_ww(double prob_ww) {
		this.prob_ww = prob_ww;
	}
	/**
	 * @return the prob_wd
	 */
	public double getProb_wd() {
		return prob_wd;
	}
	/**
	 * @param prob_wd the prob_wd to set
	 */
	public void setProb_wd(double prob_wd) {
		this.prob_wd = prob_wd;
	}
	/**
	 * @return the meanPressure
	 */
	public double getMeanPressure() {
		return meanPressure;
	}
	/**
	 * @param meanPressure the meanPressure to set
	 */
	public void setMeanPressure(double meanPressure) {
		this.meanPressure = meanPressure;
	}
	/**
	 * @return the meanHumidity
	 */
	public double getMeanHumidity() {
		return meanHumidity;
	}
	/**
	 * @param meanHumidity the meanHumidity to set
	 */
	public void setMeanHumidity(double meanHumidity) {
		this.meanHumidity = meanHumidity;
	}
	/**
	 * @return the sdPressure
	 */
	public double getSdPressure() {
		return sdPressure;
	}
	/**
	 * @param sdPressure the sdPressure to set
	 */
	public void setSdPressure(double sdPressure) {
		this.sdPressure = sdPressure;
	}
	/**
	 * @return the sdHumidity
	 */
	public double getSdHumidity() {
		return sdHumidity;
	}
	/**
	 * @param sdHumidity the sdHumidity to set
	 */
	public void setSdHumidity(double sdHumidity) {
		this.sdHumidity = sdHumidity;
	}
	/**
	 * @return the predominantCondition
	 */
	public String getPredominantCondition() {
		return predominantCondition;
	}
	/**
	 * @param predominantCondition the predominantCondition to set
	 */
	public void setPredominantCondition(String predominantCondition) {
		this.predominantCondition = predominantCondition;
	}

}
