package com.dc.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FileUtility {
	
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

}
