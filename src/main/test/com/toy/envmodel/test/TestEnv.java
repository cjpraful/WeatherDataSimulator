package com.toy.envmodel.test;

import com.toy.envmodel.run.RunEnvModel;
import com.toy.envmodel.utils.beans.InputArgs;
import com.toy.envmodel.utils.helpers.RegionInitHelper;

public class TestEnv {
	public static void main(String[] args) {
		RegionInitHelper rih = new RegionInitHelper(new InputArgs());
		rih.initModel();
	}
}
