package com.GetDetailsofPushpaMovie.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.GetDetailsofPushpaMovie.PageObject.BaseClass;
import com.GetDetailsofPushpaMovie.PageObject.WIKI;

public class ValidationDateandCountryWIKI extends BaseClass {
	@Test
	public void ComparisonofDateandCountry() throws Throwable
	{
	WIKI wiki=new WIKI(Driver);
	logger.info("Extracting Date and Country from IMDB Platform");
	String wikiDate=wiki.ExtractMovieDate();
	System.out.println(wikiDate);
	String wikiCountry=wiki.ExtractMovieCountry();
	System.out.println(wikiCountry);
	logger.info("Extracted Successfully");
	logger.info("Validation starts");
	try
	{
		Assert.assertEquals(wikiDate,"17 December 2021");
		Assert.assertEquals(wikiCountry,"India");
		logger.info("Validated Successfully, TestCase Pass ");
	}
catch(AssertionError e)
	{
		logger.info("TestCase failed");
		captureScreenshot(Driver,"ValidationDateandCountryIMDB");
		Assert.fail();
	}
	}
}
