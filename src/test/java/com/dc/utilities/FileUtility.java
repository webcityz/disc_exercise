package com.dc.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FileUtility {
	
	/**
	 * Takes a screenshot
	 * @param driver - WebDriver Instance
	 * @param strFilePathAndName - Name & Location of screenshot created
	 * @author reggy
	 */
	public static void takeAScreenshot(WebDriver driver, String strFilePathAndName) {
		try {
			//Take a screen-shot for later verification
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(strFilePathAndName));
			}
			catch(Exception ex) {
				Log.error("Couldnt take screenshot: "+"\n"+ex.getMessage());
			}
	}
	
	/**
	 * Checks if specified file exists
	 * @param strFilePathAndName - Name and Path of specified file
	 * @return True or False
	 */
	public boolean doesFileExist(String strFilePathAndName) {
		boolean bExists = false;
		File f = new File(strFilePathAndName);
		try {
			if(f.exists()) {
				bExists = true;
				Log.info(strFilePathAndName+" exists!");
			}
		}
		catch(Exception e) {
			Log.info("Could not locate "+strFilePathAndName);
		}
		return bExists;
	}

}
