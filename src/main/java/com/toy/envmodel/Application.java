package com.toy.envmodel;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.toy.envmodel.constants.ModelConstants;
import com.toy.envmodel.dto.InputArgsDTO;
import com.toy.envmodel.generators.EnvValueGenerator;
import com.toy.envmodel.helpers.DateValidator;
import com.toy.envmodel.helpers.RegionInitHelper;
import com.toy.envmodel.models.Region;

/**
 * RunEnvModel.java - Entry class. Accepts start date and endDate parameters for generating Weather Data 
 * @author praful
 * 
 */

public class Application {

	public  static Logger logger = Logger.getLogger(Application.class);

	public static void main(String[] args){
		if(args.length >= 2){

			String startDate = args[0];
			String endDate = args[1];	
			DateValidator dateValidator = new DateValidator();

			if(dateValidator.isValidDates(startDate,endDate,ModelConstants.DATE_FORMAT)){
				DateTimeFormatter formatter = DateTimeFormat.forPattern(ModelConstants.DATE_FORMAT);
				
				InputArgsDTO inpArgs =  new InputArgsDTO();
				
				inpArgs.setStartDate(DateTime.parse(startDate, formatter));
				inpArgs.setEndDate(DateTime.parse(endDate, formatter));

				RegionInitHelper rih = new RegionInitHelper(inpArgs);
				List<Region> regions  = rih.initModel();

				if(regions != null && regions.size()>0 ){
					EnvValueGenerator envValGen = new EnvValueGenerator();
					envValGen.generateEnvValues(regions, inpArgs);
				}
			}
		}else{
			logger.error("Input parameters missing");
		}
	}
}
