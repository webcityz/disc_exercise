package com.features.runner;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cucumber.listener.ExtentProperties;
import com.dc.utilities.BaseLine;
import com.dc.utilities.ExtentReportsUtility;
import com.dc.utilities.TestProperties;
import com.dc.utilities.TimesAndDates;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(monochrome = true, features = {"src//test//java//com//dc//features"},
		glue = {"classpath:com.dc.stepdefinitions"},
		tags = {"@regressiontests"},
		plugin= {"pretty", "html:target/cucumber-htmlreport",
				"json:target/cucumber.json", "com.cucumber.listener.ExtentCucumberFormatter:" })

public class RunTests extends AbstractTestNGCucumberTests {
	static String strTestReport = TestProperties.ReportsDirectory+File.separator+"BddTest_"+TimesAndDates.getCurrentTimeAndDate()
	.replaceAll("/", "_").replaceAll(":", "_").replaceAll(" ", "")+".html";
	
	static ExtentHtmlReporter htmlReports = new ExtentHtmlReporter(strTestReport);
	static ExtentReports extent = new ExtentReports();
	BaseLine bl = new BaseLine();
	
	
	@BeforeClass
	public static void setUp() {
		ExtentProperties ep = ExtentProperties.INSTANCE;
		
		ep.setReportPath(strTestReport);
	}
	
	@AfterClass
	public static void tearDown() {
		ExtentReportsUtility eru = new ExtentReportsUtility();
		eru.setUpExtentReport();
	}
	
}
