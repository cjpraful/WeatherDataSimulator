package com.toy.envmodel.utils.helpers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.toy.envmodel.constants.ModelConstants;

/**
 * InputUtil.java - Reads Observed Weather data from input file
 * @author praful
 * 
 */

public class InputUtil {
	public static List<String> meanWeatherData;
	public  static Logger logger = Logger.getLogger(InputUtil.class);

	public List<String> getObservedWeatherInput(){	
		meanWeatherData = readfromFile(ModelConstants.INPUT_FILE);	
		return meanWeatherData;	
	}

	public  List<String> readfromFile(String fileName){

		String line= ""; 
		List<String> 	fileData =new ArrayList<String>();

		try { 
			ClassLoader classLoader = this.getClass().getClassLoader(); 

			InputStream inputStream = classLoader.getResourceAsStream(fileName);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

			while ((line = reader.readLine()) != null){
				fileData.add(line);
			}

			if(reader!=null)
				reader.close(); 

		} catch (Exception  e) {
			logger.error("Input FileRead error");
		}finally{
			return fileData;
		}
	}

}
