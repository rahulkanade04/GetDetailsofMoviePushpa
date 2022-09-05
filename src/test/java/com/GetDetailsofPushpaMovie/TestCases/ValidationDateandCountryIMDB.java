package com.GetDetailsofPushpaMovie.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.GetDetailsofPushpaMovie.PageObject.BaseClass;
import com.GetDetailsofPushpaMovie.PageObject.IMDB;
public class ValidationDateandCountryIMDB extends BaseClass {
	@Test
public void ComparisonofDateandCountry() throws Throwable {
IMDB imdb=new IMDB(Driver);
logger.info("Extracting Date and Country from IMDB Platform");
String imdbDate=imdb.ExtractMovieDate();
System.out.println(imdbDate);
String imdbCountry=imdb.ExtractMovieCountry();
System.out.println(imdbCountry);
logger.info("Extracted Successfully");
logger.info("Validation starts");
try
	{
		Assert.assertEquals(imdbDate,"January 7, 2022 (United states)");
		Assert.assertEquals(imdbCountry,"India");
		logger.info("Validated Successfully, TestCase Pass ");
	}
catch(AssertionError e)
	{
		logger.info("TestCase failed");
		captureScreenshot(Driver,"ValidationDateandCountryIMDB");
		Assert.fail("Extracted Date or Country is not Matched with Expected Date or Country");
	}
	}

}
