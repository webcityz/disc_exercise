package com.dc.utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseLine implements ITestListener {
	protected static WebDriver driver;
	protected static ExtentReports reports;
	protected static ExtentHtmlReporter reporter;
	protected static ExtentTest test;
	protected static String strTestStarted;
	protected static String strTestName;
	protected static String strTestCase;
	
	private final static String strOperatingSystem = System.getProperty("os.name").toUpperCase();
	private final static String strSystemArchitecture = System.getProperty("os.arch");
	private static String sBrowserType = TestProperties.getTestProperty("browser");
	private static int iTestNum = 0;
	
	ExtentReportsUtility extRepUtil = new ExtentReportsUtility();
	
	public BaseLine() {
		BaseLine.driver = getDriver();
	}

	/**
	 * Sets up the WebDriver instance based on settings in test.properties
	 * @return WebDriver Instance
	 * @author reggy
	 */
	public WebDriver getDriver() {
		if(null == driver) {
			Log.info("The browser used in this test: "+sBrowserType);
			Log.info("The current operating system: "+strOperatingSystem);
			Log.info("The current architecture: "+strSystemArchitecture);
			if(System.getProperty("browser")!=null) {
				sBrowserType = System.getProperty("browser");
			}
			
			switch(sBrowserType.toLowerCase()) {
			case "firefox":
				System.setProperty("webdriver.gecko.driver", TestProperties.ResourcesDirectory+"geckodriver.exe");
				try {
					FirefoxOptions options = new FirefoxOptions();
					options.setBinary("C:"+File.separator+"Program Files"+File.separator+"Mozilla Firefox"+File.separator+"firefox.exe");
					driver = new FirefoxDriver(options);
				}
				catch(Exception ex) {
					Log.error("Error getting firefox driver: "+ex.getMessage());
				}
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", TestProperties.ResourcesDirectory+"chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				String strChromePath = "AppData"+File.separator+"Local"+File.separator+"Google"+File.separator+"Chrome"+File.separator+"Application";
				String strPath = "C:"+File.separator+"Users"+File.separator+System.getProperty("user.name")+File.separator+strChromePath+File.separator+"chrome.exe";
				//String sPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
				options.setBinary(strPath);
				options.addArguments("--dns-prefetch-disable");
				options.addArguments("--always-authorize-plugins");
				driver = new ChromeDriver(options);
				break;
			case "microsoft edge":
				System.setProperty("webdriver.edge.driver", TestProperties.ResourcesDirectory+"MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
				break;
			case "internet explorer":
				System.setProperty("webdriver.ie.driver", TestProperties.ResourcesDirectory+"IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			case "phantomjs":
				System.setProperty("phantomjs.binary.path", TestProperties.ResourcesDirectory+"phantomjs.exe");
				break;
			default:
				Log.info("Specified browser not recognised. Defaulting to Firefox...");
				System.setProperty("webdriver.gecko.driver", TestProperties.ResourcesDirectory+"geckodriver.exe");
				try {
					FirefoxOptions defaultOptions = new FirefoxOptions();
					defaultOptions.setBinary("C:"+File.separator+"Program Files"+File.separator+"Mozilla Firefox"+File.separator+"firefox.exe");
					driver = new FirefoxDriver(defaultOptions);
				}
				catch(Exception ex) {
					Log.error("Error getting firefox driver: "+ex.getMessage());
				}
			}
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub	
	}

}
