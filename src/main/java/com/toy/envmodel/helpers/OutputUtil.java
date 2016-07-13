package com.toy.envmodel.helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.log4j.Logger;

import com.toy.envmodel.constants.ModelConstants;
import com.toy.envmodel.dto.EnvValuesDTO;
import com.toy.envmodel.models.Region;

/**
 * OutputUtil.java - Write\Append generated weather data to Output file
 * @author praful
 * 
 */ 

public class OutputUtil {

	static StringBuilder outString = new StringBuilder();
	static Logger logger = Logger.getLogger(OutputUtil.class);
	BufferedWriter out;
	
	public void writeToOut(Region region){

		outString.setLength(0);
		EnvValuesDTO envValues= region.getEnvValuesGenerated();
		outString.append(region.getRegionCode()).append(ModelConstants.OUT_DELIM)
		.append(region.getLatitude()).append(ModelConstants.COMMA)
		.append(region.getLongitude()).append(ModelConstants.COMMA)
		.append(region.getObsInfo().getObservedDaysInitial()).append(ModelConstants.OUT_DELIM)
		.append(region.getCurrentDate().toYearMonthDay()).append(region.getTimePart()).append(ModelConstants.OUT_DELIM)
		.append(envValues.getCondition()).append(ModelConstants.OUT_DELIM)
		.append(envValues.getTemperature()).append(ModelConstants.OUT_DELIM)
		.append(envValues.getPressure()).append(ModelConstants.OUT_DELIM)
		.append(envValues.getHumidity());

		writeToFile(outString+"",ModelConstants.OUTPUT_FILE);

		logger.info(outString+"");
	}

	public void writeToFile(String contents,String fileName){
		File file = new File (fileName);
		try {
			if(!file.exists()){
				file.createNewFile();
			}
			out = new BufferedWriter(new FileWriter(file,true));
			out.write(contents);
			out.write("\n");
			out.close();
		} catch (IOException e) {
			logger.warn("Output file Error "+e);
		} 
	}
}
