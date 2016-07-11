package com.toy.envmodel.utils.helpers;

import static org.junit.Assert.*;

import org.junit.Test;

import com.toy.envmodel.helpers.DateValidator;

public class TestDateValidator {

	@Test
	public void testIsValidDates() {
		DateValidator dateValidator = new DateValidator();
		assertEquals(true,dateValidator.isValidDates("2015-4-24", "2016-5-24", "yyyy-MM-dd"));
		assertEquals(false,dateValidator.isValidDates("2016-05-25", "2016-5-24", "yyyy-MM-dd"));
		assertEquals(false,dateValidator.isValidDates("1988-apr-24", "2016-5-24", "yyyy-MM-dd"));
	}

	@Test
	public void testIsThisDateValid() {
		DateValidator dateValidator = new DateValidator();
		assertEquals(true,dateValidator.isThisDateValid("1988-4-24", "yyyy-MM-dd"));
		assertEquals(false,dateValidator.isThisDateValid("1988-21-24", "yyyy-MM-dd"));
		assertEquals(false,dateValidator.isThisDateValid("1988-apr-24", "yyyy-MM-dd"));
	}

	@Test
	public void testCompareDates() {
		DateValidator dateValidator = new DateValidator();
		assertEquals(true,dateValidator.compareDates("2015-4-24", "2016-5-24", "yyyy-MM-dd"));
		assertEquals(false,dateValidator.compareDates("2016-4-24", "2015-5-24", "yyyy-MM-dd"));
		assertEquals(false,dateValidator.compareDates("2016-5-24", "2016-5-23", "yyyy-MM-dd"));
	}

}
