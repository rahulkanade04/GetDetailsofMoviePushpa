package com.GetDetailsofPushpaMovie.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
Properties pro;
public ReadConfig ()
{
	File src=new File("./Configuration\\config.properties");
	try {
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Exception is"+e.getMessage());
	}
}
public String getApplicationURL() {
	String url=pro.getProperty("baseurl");
	return url;
}
public String getChromeBrowser() {
	String chrome=pro.getProperty("Chromepath");
	return chrome;
}
}
