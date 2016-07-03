package com.toy.envmodel.models;


/**
 * Geography.java - 
 * @author praful
 * 
 */
public class Geography {

	String latitude;
	String longitude;
	double deltaFactorTemp;
	//TODO Add more params

	/**
	 * @return the deltaFactorTemp
	 */
	public double getDeltaFactorTemp() {
		return deltaFactorTemp;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @param deltaFactorTemp the deltaFactorTemp to set
	 */
	public void setDeltaFactorTemp(double deltaFactorTemp) {
		this.deltaFactorTemp = deltaFactorTemp;
	}

}
