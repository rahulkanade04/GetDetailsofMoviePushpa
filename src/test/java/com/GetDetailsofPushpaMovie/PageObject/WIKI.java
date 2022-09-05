package com.GetDetailsofPushpaMovie.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WIKI {
	WebDriver Driver;
	public WIKI(WebDriver Driver)
	{
		PageFactory.initElements(Driver,this);
	}
	@FindBy(xpath="//tbody/tr[12]/td[1]/div[1]/ul[1]/li[1]")
	WebElement Date;
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[3]/div[5]/div[1]/table[1]/tbody[1]/tr[14]/td[1]")
	WebElement Country;
	public String ExtractMovieDate()
	{
		String ExtractDate=Date.getText();
		return ExtractDate;
	}
	public String ExtractMovieCountry()
	{
		String ExtractCountry=Country.getText();
		return ExtractCountry;
	}
}
