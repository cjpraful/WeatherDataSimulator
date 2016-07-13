package com.toy.envmodel.constants;

/**
 * ModelConstants.java - A class for Constants 
 * @author praful
 * 
 */

public class ModelConstants {

	public static enum months {JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC};
	
	public static final String OUT_DELIM = "|";
	public static final String TIME_START ="T";
	public static final String TIME_END = "Z";
	public static final String COMMA = ",";
	
	public static final String CONDITION_RAIN = "RAIN";
	public static final String CONDITION_SNOW = "SNOW";
	public static final String CONDITION_OVERCAST = "OVERCAST";
	public static final String CONDITION_SUNNY = "SUNNY";

	//public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	
	public static final String INPUT_FILE = "input/ObservedWeatherData.txt";	
	public static final String OUTPUT_FILE = "src/main/resources/output/WeatherTestData.txt";
	
}
