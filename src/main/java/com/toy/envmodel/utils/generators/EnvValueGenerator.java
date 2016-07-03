package com.toy.envmodel.utils.generators;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import com.toy.envmodel.constants.ModelConstants;
import com.toy.envmodel.models.Region;
import com.toy.envmodel.observations.RegionObservedParams;
import com.toy.envmodel.utils.beans.EnvValues;
import com.toy.envmodel.utils.beans.InputArgs;
import com.toy.envmodel.utils.helpers.GeneratorUtil;
import com.toy.envmodel.utils.helpers.OutputUtil;
/**
 * EnvValueGenerator.java - Generates Weather data based on StartDate, end Date and observedWeatherData
 * @author praful
 * 
 */
public class EnvValueGenerator {

	private InputArgs inpArgs;
	public List<Region> regions;
	public OutputUtil outputUtil;
	
	public List<Region> generateEnvValues(List<Region> regionsinp, InputArgs inpArgs){

		this.inpArgs = inpArgs;
		Date currentDate = inpArgs.getStartDate();
		Date endDate = inpArgs.getEndDate();
		this.regions = regionsinp;

		while(currentDate.compareTo(endDate)<=0){

			for(Region region: regions){

				EnvValues envValGenerated = region.getEnvValuesGenerated();
				if(envValGenerated==null){
					envValGenerated = new EnvValues();
				}

				region.setCurrentDate(currentDate);

				region.setTimePart(GeneratorUtil.getTime());
				@SuppressWarnings("deprecation")

				Integer month  = new Integer(region.getCurrentDate().getMonth()+1);
				RegionObservedParams regObsParams = region.getMonthObservedParamMapping().get(month);

				//Get the weather condition
				double pww = regObsParams.getProb_ww();
				double pwd = regObsParams.getProb_wd();
				boolean isPrevDayWet = region.isPrevDayWet();
				String predomSnowOrRain = regObsParams.getPredominantCondition();
				String weatherCondition = getCondition(pww, pwd, isPrevDayWet, predomSnowOrRain);
				envValGenerated.setCondition(weatherCondition);
				
				if (weatherCondition.contains(ModelConstants.CONDITION_RAIN)
						|| weatherCondition
						.contains(ModelConstants.CONDITION_SNOW)) {
					region.setPrevDayWet(true);
				}else{
					region.setPrevDayWet(false);

				}
				//Calculate temperatures
				double generatedTemp = generateTempValues(region,regObsParams);
				//TODO Correction /evoving factor to be done here if any;
				envValGenerated.setTemperature(generatedTemp);

				//Calculate Pressure
				double generatedPressure = generatePressureValues(region,regObsParams);
				//TODO Correction /evoving factor to be done here if any;
				envValGenerated.setPressure(generatedPressure);

				//Calculate Humidity

				double generatedHumidity = generateHumidityValues(region,regObsParams);
				//TODO Correction /evoving factor to be done here if any;
				envValGenerated.setHumidity(generatedHumidity);

				region.setEnvValuesGenerated(envValGenerated);

				//write to out
				outputUtil = new OutputUtil();
				outputUtil.writeToOut(region);


			}
			currentDate = GeneratorUtil.addDays(currentDate, 1);
		}

		return this.regions;
	}


	private double generateTempValues(Region region, RegionObservedParams regObsParams){


		double avgTemp=regObsParams.getMeanTemperature();
		double sdTemp = regObsParams.getSdTemperature();
		//random.setSeed((long)avgval);
		//mean of avgval and sd
		double generatedTemp = avgTemp+region.getGaussTempRandom().nextGaussian()*sdTemp;
		return Double.parseDouble(String.format("%.2f",generatedTemp));


	}




	private double generateHumidityValues(Region region, RegionObservedParams regObsParams) {
		Random random = new Random();
		double avgHumidity=regObsParams.getMeanHumidity();
		double sdHumidity = regObsParams.getSdHumidity();
		//mean of avgval and sd
		
		double generatedHumidity = avgHumidity+region.getGaussHumidityRandom().nextGaussian()*sdHumidity;	
		
		return Double.parseDouble(String.format("%.0f",generatedHumidity));
	}


	private double generatePressureValues(Region region, RegionObservedParams regObsParams) {

		Random random = new Random();
		double avgPressure=regObsParams.getMeanPressure();
		double sdPressure = regObsParams.getSdPressure();
		//random.setSeed((long)avgval);
		//mean of avgval and sd
		double generatedPressure = avgPressure+region.getGaussPressureRandom().nextGaussian()*sdPressure;
		return Double.parseDouble(String.format("%.2f",generatedPressure));
	}


	public static String getCondition(double pww,double pwd,boolean isPrevDayWet, String predom){
		String condition= predom;

		Random random= new Random();
		double wetProbability = 0;
		if(isPrevDayWet){
			wetProbability = pww+(random.nextGaussian()*0.2);
			if(wetProbability>0.6){
				condition = predom;
			}else if(wetProbability>0.45){
				if(predom.contains(ModelConstants.CONDITION_SNOW)){
					condition = predom;
				}else{
					condition= ModelConstants.CONDITION_OVERCAST;
				}
			}else{
				condition= ModelConstants.CONDITION_SUNNY;
			}
		}else{
			wetProbability = pww+(random.nextGaussian()*0.15);

			if(wetProbability>0.5){
				condition = predom;
			}else if(wetProbability>0.35){

				if(predom.contains(ModelConstants.CONDITION_SNOW)){
					condition = predom;
				}else{
					condition = ModelConstants.CONDITION_OVERCAST;
				}
			}else{
				condition= ModelConstants.CONDITION_SUNNY;
			}
		}

		return condition;


	}
}