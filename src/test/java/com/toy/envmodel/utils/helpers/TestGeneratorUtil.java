package com.toy.envmodel.utils.helpers;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

import com.toy.envmodel.helpers.GeneratorUtil;

public class TestGeneratorUtil {
	@Test
	public void testAddDays() {
		
		assertEquals("2016-05-26", GeneratorUtil.addDays(Date.valueOf("2016-05-24"), 2).toString());
		assertEquals("2016-05-22", GeneratorUtil.addDays(Date.valueOf("2016-05-24"), -2).toString());
	}

	

}
