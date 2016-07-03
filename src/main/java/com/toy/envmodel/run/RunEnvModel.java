package com.toy.envmodel.run;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.toy.envmodel.constants.ModelConstants;
import com.toy.envmodel.models.Region;
import com.toy.envmodel.utils.beans.InputArgs;
import com.toy.envmodel.utils.generators.EnvValueGenerator;
import com.toy.envmodel.utils.helpers.DateValidator;
import com.toy.envmodel.utils.helpers.RegionInitHelper;

/**
 * RunEnvModel.java - Entry class. Accepts start date and endDate parameters for generating Weather Data 
 * @author praful
 * 
 */

public class RunEnvModel {

	public  static Logger logger = Logger.getLogger(RunEnvModel.class);

	public static void main(String[] args){
		if(args.length >= 2){

			String startDate = args[0];
			String endDate = args[1];	
			DateValidator dateValidator = new DateValidator();

			if(dateValidator.isThisDateValid(startDate,ModelConstants.DATE_FORMAT) && 
					dateValidator.isThisDateValid(endDate,ModelConstants.DATE_FORMAT)){

				InputArgs inpArgs =  new InputArgs();
				inpArgs.setStartDate(Date.valueOf(startDate));
				inpArgs.setEndDate(Date.valueOf(endDate));

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
