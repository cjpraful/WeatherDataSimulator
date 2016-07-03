package com.toy.envmodel.utils.beans;

import java.io.Serializable;
import java.util.Date;
/**
 * EnvValues.java - JavaBean for EnvironmentVariables Temperature, Pressure, Humidity
 * @author praful
 * 
 */
public class EnvValues implements Serializable{

	private Date meaasuredDate;
	private double temperature;
	private double pressure;
	private double humidity;
	
	/**
	 * @return the meaasuredDate
	 */
	public Date getMeaasuredDate() {
		return meaasuredDate;
	}
	/**
	 * @param meaasuredDate the meaasuredDate to set
	 */
	public void setMeaasuredDate(Date meaasuredDate) {
		this.meaasuredDate = meaasuredDate;
	}
	//Whether SNOWY,RAINY,SUNNY etc
	String condition;
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getPressure() {
		return pressure;
	}
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	} 
	
	
}
