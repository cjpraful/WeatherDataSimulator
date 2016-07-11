package com.toy.envmodel.helpers;

import java.util.List;

import com.toy.envmodel.dto.InputArgsDTO;
import com.toy.envmodel.models.Region;

/**
 * GeographyInitHelper.java - 
 * @author praful
 * 
 */

public abstract class GeographyInitHelper {

	private InputArgsDTO inputArgs;
	public GeographyInitHelper(InputArgsDTO inputArgs){
		this.inputArgs = inputArgs;
	}
	
	
	public abstract List<Region> initModel();
	

	
}
