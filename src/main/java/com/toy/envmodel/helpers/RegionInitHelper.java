package com.toy.envmodel.helpers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.toy.envmodel.constants.ModelConstants;
import com.toy.envmodel.dto.InputArgsDTO;
import com.toy.envmodel.dto.ObservationInfoDTO;
import com.toy.envmodel.dto.RegionObservedParamsDTO;
import com.toy.envmodel.models.Region;

/**
 * RegionInitHelper.java - Helper class for Region specific data
 * @author praful
 * 
 */
public class RegionInitHelper extends GeographyInitHelper {

	public RegionInitHelper(InputArgsDTO inputArgs) {
		super(inputArgs);
	}

	@Override
	public List<Region> initModel() {

		List<Region> regions = new ArrayList<Region>();

		InputUtil inpUtil = new InputUtil();
		List<String> obsRegsParam  = inpUtil.getObservedWeatherInput();
		if(obsRegsParam != null && obsRegsParam.size() > 0){

			for(String obsRegParamString : obsRegsParam){
				String[] obsRegParams = obsRegParamString.split(ModelConstants.COMMA);

				Region region =  new Region();

				region.setRegionName(obsRegParams[0]);
				region.setRegionCode(obsRegParams[1]);
				region.setLatitude(obsRegParams[2]);
				region.setLongitude(obsRegParams[3]);

				ObservationInfoDTO obsInfo = new ObservationInfoDTO();
				obsInfo.setObservedDaysInitial(Long.parseLong(obsRegParams[4]));
				obsInfo.setObservationEndDate(Date.valueOf(obsRegParams[5]));

				Map<Integer,RegionObservedParamsDTO> regMonthObsMap = null;
				RegionObservedParamsDTO regObsParams=null;

				for(int index=6; index<18;index= index+1){

					String monthDetails = obsRegParams[index];
					String[] obsMonthParams = monthDetails.split(Pattern.quote("|"));
					int idx =0;
					regObsParams= new RegionObservedParamsDTO();


					regObsParams.setMonth(obsMonthParams[idx]);
					regObsParams.setProb_ww(Double.parseDouble(obsMonthParams[idx+1]));
					regObsParams.setProb_wd(Double.parseDouble(obsMonthParams[idx+2]));
					regObsParams.setMeanTemperature(
							Double.parseDouble(obsMonthParams[idx+3]));
					regObsParams.setSdTemperature(Double.parseDouble(obsMonthParams[idx+4]));
					regObsParams.setMeanPressure(Double.parseDouble(obsMonthParams[idx+5]));
					regObsParams.setSdPressure(Double.parseDouble(obsMonthParams[idx+6]));
					regObsParams.setMeanHumidity(Double.parseDouble(obsMonthParams[idx+7]));
					regObsParams.setSdHumidity(Double.parseDouble(obsMonthParams[idx+8]));
					regObsParams.setPredominantCondition(obsMonthParams[idx+9]);

					regMonthObsMap =  region.getMonthObservedParamMapping();
					if(regMonthObsMap==null){
						regMonthObsMap = new HashMap<Integer,RegionObservedParamsDTO>();
					}
					regMonthObsMap.put(new Integer(regObsParams.getMonth()), regObsParams);
					region.setMonthObservedParamMapping(regMonthObsMap);

				}
				region.setMonthObservedParamMapping(regMonthObsMap);
				region.setObsInfo(obsInfo);
				regions.add(region);
			}
			return regions;
		}
		return null;


	}



}