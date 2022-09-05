package com.GetDetailsofPushpaMovie.PageObject;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.GetDetailsofPushpaMovie.Utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	public String baseurl=readconfig.getApplicationURL();
	public static WebDriver Driver;
	public static Logger logger;
@SuppressWarnings("deprecation")
@Parameters("browser")
@BeforeClass
public void setup(String br) throws InterruptedException
		{
	
	logger=Logger.getLogger("GetDetailsofPushpaMovie");
	PropertyConfigurator.configure("Log4j.properties");
	if (br.equals("IMDB"))
	{
	System.setProperty("webdriver.chrome.driver",readconfig.getChromeBrowser());
	Driver=new ChromeDriver();
	Driver.manage().window().maximize();
	Driver.get("https://www.imdb.com/title/tt9389998/");
	JavascriptExecutor js=(JavascriptExecutor)Driver;
	js.executeScript("window.scrollBy(0,5750)");
	Thread.sleep(10000);
	Driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	else if(br.equals("WIKI"))
	{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromeBrowser());
		Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		JavascriptExecutor js=(JavascriptExecutor)Driver;
		js.executeScript("window.scrollBy(0,850)");
		Thread.sleep(10000);
		Driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
		}
@AfterClass
public void teardown()
{
	Driver.quit();
}
public void captureScreenshot(WebDriver Driver, String tname) throws IOException
{
TakesScreenshot ts=(TakesScreenshot)Driver;
File source=ts.getScreenshotAs(OutputType.FILE);
File target=new File(System.getProperty("user.dir") + "/Screenshot/" + tname + ".png");
FileUtils.copyFile(source, target);
System.out.println("ScreenShot Taken");
}
}