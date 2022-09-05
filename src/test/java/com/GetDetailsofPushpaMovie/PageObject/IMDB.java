package com.GetDetailsofPushpaMovie.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IMDB {
WebDriver Driver;
public IMDB(WebDriver Driver)
{
	PageFactory.initElements(Driver,this);
}
@FindBy(xpath="/html[1]/body[1]/div[2]/main[1]/div[1]/section[1]/div[1]/section[1]/div[1]/div[1]/section[10]/div[2]/ul[1]/li[1]/div[1]/ul[1]/li[1]/a[1]")
WebElement Date;
@FindBy(xpath="/html[1]/body[1]/div[2]/main[1]/div[1]/section[1]/div[1]/section[1]/div[1]/div[1]/section[10]/div[2]/ul[1]/li[2]/div[1]/ul[1]/li[1]/a[1]")
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