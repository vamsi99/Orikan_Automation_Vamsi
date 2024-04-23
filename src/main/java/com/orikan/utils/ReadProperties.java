package com.orikan.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {
	
	public static Properties pro;
	public static String projectLocation = "D:\\Orikan_Automation\\Automation\\OrikanAutomation\\src\\resource";
	
	
	public String getProperty(String Key) {
		try {
			return pro.getProperty(Key);
		}catch(Exception e) {
			return "";
		}
	}
	
	public ReadProperties() throws Throwable {
		pro = new Properties();
		File userConfig = new File(projectLocation + "Config.properties");
		if(userConfig.exists()) {
			FileInputStream fis = new FileInputStream(userConfig);
			pro.load(fis);
		}
	}
	
}
