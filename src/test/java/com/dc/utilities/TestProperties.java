package com.dc.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	public static final String WorkingDirectory = System.getProperty("user.dir");
	public static final String HomeDirectory = System.getProperty("user.dir").replace("eclipse-workspace\\DiscoveryAutoTest", "");
	public static final String ResourcesDirectory = WorkingDirectory+File.separator+"resources"+File.separator;
	public static final String ReportsDirectory = WorkingDirectory+File.separator+"reports"+File.separator;
	public static final String LogsDirectory = WorkingDirectory+File.separator+"logs"+File.separator;
	
	public static final int SHORT_WAIT = 100;
	public static final int MEDIUM_WAIT = 1000;
	public static final int LONG_WAIT = 6000;
	/**
	 * Retrieves configurable properties from test.properties
	 * @param strPropertyName - Key of property to be retrieved
	 * @return strProperty - Value of property to be retrieved
	 * @author reggy
	 */
	public static String getTestProperty(String strPropertyName) {
		Properties prop = new Properties();
		String strProperty = "";
		FileInputStream file;
		try {
			file = new FileInputStream(ResourcesDirectory+"test.properties");
			prop.load(file);
		}
		catch(IOException ex) {
			Log.error("Error reading property from file "+ex.getMessage());
		}
		strProperty = prop.getProperty(strPropertyName).toLowerCase();
		Log.info(strPropertyName+" set to: "+strProperty);
		
		return strProperty;
	}
}
