package com.toy.envmodel.utils.helpers;

import java.util.List;

import com.toy.envmodel.models.Region;
import com.toy.envmodel.utils.beans.InputArgs;

/**
 * GeographyInitHelper.java - 
 * @author praful
 * 
 */

public abstract class GeographyInitHelper {

	private InputArgs inputArgs;
	public GeographyInitHelper(InputArgs inputArgs){
		this.inputArgs = inputArgs;
	}
	
	
	public abstract List<Region> initModel();
	

	
}
