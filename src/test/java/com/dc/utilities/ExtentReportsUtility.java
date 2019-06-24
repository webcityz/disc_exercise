package com.dc.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsUtility {
	ExtentHtmlReporter htmlReports;
	ExtentReports extent;
	ExtentTest test;
	String strFileName = TestProperties.ReportsDirectory+File.separator;
	
	
	public void setUpExtentReport() {
		
		htmlReports = new ExtentHtmlReporter(strFileName);
		extent = new ExtentReports();
		extent.attachReporter(htmlReports);
		htmlReports.config().setReportName("Test Report Sample");
		htmlReports.config().setTheme(Theme.STANDARD);
		htmlReports.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReports.config().setDocumentTitle("Discovery Channel Recruitment Exercise");
		
		extent.setSystemInfo("Environment Under Test: ", TestProperties.getTestProperty("environment"));
		extent.setSystemInfo("Section: ", "Product Subscription");
		extent.setSystemInfo("Available processors (cores): ", Runtime.getRuntime().availableProcessors()+"");
		extent.setSystemInfo("Free memory (bytes): ", Runtime.getRuntime().freeMemory()+"");
		long maxMemory = Runtime.getRuntime().maxMemory();
		extent.setSystemInfo("Maximum memory (bytes): ", (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory)+"");
		extent.setSystemInfo("Total memory available to JVM (bytes): ", Runtime.getRuntime().totalMemory()+"");
		extent.setSystemInfo("OS Name: ", System.getProperty("os.name") );
		extent.setSystemInfo("OS Version: ", System.getProperty("os.version") );
		 
		extent.setSystemInfo("OS Architecture: ", System.getProperty("os.arch") );
		extent.setSystemInfo("Current User: ", System.getProperty("user.name") );
		extent.setSystemInfo("Java Version: ", System.getProperty("java.version") );
		extent.setSystemInfo("Java Vendor: ", System.getProperty("java.vendor") );
		 
		 setExtentHtmlReport(htmlReports);

		 setExtentReport(extent);
	}
	
	public void setExtentHtmlReport(ExtentHtmlReporter ehr) {
		this.htmlReports = ehr;
	}
	
	public void setExtentReport(ExtentReports extRep) {
		this.extent = extRep;
	}
	

}
