package com.toy.envmodel.test;

import java.util.Random;

import com.toy.envmodel.constants.ModelConstants;

public class TestConditioon {

	
	public static void main(String[] args) {
		
		System.out.println(getCondition(0.502, 0.262, false, "SNOW"));
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
