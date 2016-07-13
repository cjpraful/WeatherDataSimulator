package com.toy.envmodel.models;

import java.util.Map;
import java.util.Random;

import org.joda.time.DateTime;

import com.toy.envmodel.dto.EnvValuesDTO;
import com.toy.envmodel.dto.ObservationInfoDTO;
import com.toy.envmodel.dto.RegionObservedParamsDTO;
/**
 * Region.java - 
 * @author praful
 * 
 */
public class Region extends Geography{

	String regionName;
	String regionCode;
	Map<Integer,RegionObservedParamsDTO> monthObservedParamMapping;
	ObservationInfoDTO obsInfo;

	DateTime currentDate;
	String timePart;
	EnvValuesDTO envValuesGenerated;

	boolean isPrevDayWet;

	Random gaussTempRandom;
	Random gaussPressureRandom;
	Random gaussHumidityRandom;

	int monthTempVal;
	int monthHumidityVal;

	int monthPressureVal;


	/**
	 * @return the envValuesGenerated
	 */
	public EnvValuesDTO getEnvValuesGenerated() {
		return envValuesGenerated;
	}
	/**
	 * @param envValuesGenerated the envValuesGenerated to set
	 */
	public void setEnvValuesGenerated(EnvValuesDTO envValuesGenerated) {
		this.envValuesGenerated = envValuesGenerated;
	}
	/**
	 * @return the currentDate
	 */
	public DateTime getCurrentDate() {
		return currentDate;
	}
	/**
	 * @param currentDate the currentDate to set
	 */
	public void setCurrentDate(DateTime currentDate) {
		this.currentDate = currentDate;
	}
	/**
	 * @return the obsInfo
	 */
	public ObservationInfoDTO getObsInfo() {
		return obsInfo;
	}
	/**
	 * @param obsInfo the obsInfo to set
	 */
	public void setObsInfo(ObservationInfoDTO obsInfo) {
		this.obsInfo = obsInfo;
	}
	/**
	 * @return the regionName
	 */
	public String getRegionName() {
		return regionName;
	}
	/**
	 * @param regionName the regionName to set
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	/**
	 * @return the regionCode
	 */
	public String getRegionCode() {
		return regionCode;
	}
	/**
	 * @param regionCode the regionCode to set
	 */
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	/**
	 * @return the monthObservedParamMapping
	 */
	public Map<Integer, RegionObservedParamsDTO> getMonthObservedParamMapping() {
		return monthObservedParamMapping;
	}
	/**
	 * @param monthObservedParamMapping the monthObservedParamMapping to set
	 */
	public void setMonthObservedParamMapping(
			Map<Integer, RegionObservedParamsDTO> monthObservedParamMapping) {
		this.monthObservedParamMapping = monthObservedParamMapping;
	}
	
	/**
	 * @return the timePart
	 */
	public String getTimePart() {
		return timePart;
	}
	
	/**
	 * @param timePart the timePart to set
	 */
	public void setTimePart(String timePart) {
		this.timePart = timePart;
	}
	
	/**
	 * @return the gaussTempRandom
	 */
	public Random getGaussTempRandom() {
		if(monthTempVal!=currentDate.getMonthOfYear()){
			gaussTempRandom = new Random();
			monthTempVal=currentDate.getMonthOfYear();
		}else{
			if(gaussTempRandom == null){
				gaussTempRandom = new Random();
			}
		}
		return gaussTempRandom;
	}
	
	/**
	 * @return the gaussPressureRandom
	 */
	public Random getGaussPressureRandom() {

		if(monthPressureVal!=currentDate.getMonthOfYear()){
			gaussPressureRandom = new Random();
			monthPressureVal=currentDate.getMonthOfYear();
		}else{
			if(gaussPressureRandom == null){
				gaussPressureRandom = new Random();
			}
		}
		return gaussPressureRandom;


	}
	
	/**
	 * @return the gaussHumidityRandom
	 */
	public Random getGaussHumidityRandom() {
		if(monthHumidityVal!=currentDate.getMonthOfYear()){
			gaussHumidityRandom = new Random();
			monthHumidityVal=currentDate.getMonthOfYear();
		}else{
			if(gaussHumidityRandom == null){
				gaussHumidityRandom = new Random();
			}
		}
		return gaussHumidityRandom;
	}
	
	/**
	 * @return the isPrevDayWet
	 */
	public boolean isPrevDayWet() {
		return isPrevDayWet;
	}
	
	/**
	 * @param isPrevDayWet the isPrevDayWet to set
	 */
	public void setPrevDayWet(boolean isPrevDayWet) {
		this.isPrevDayWet = isPrevDayWet;
	}


}