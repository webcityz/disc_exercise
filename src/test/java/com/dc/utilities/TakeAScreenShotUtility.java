package com.dc.utilities;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class TakeAScreenShotUtility {
	/**
	 * Takes a screen shot of current page
	 * @param driver - WebDriver Instance
	 * @param screenshot - Name of screenshot
	 * @return Destination of the Image created
	 * @throws IOException
	 * @author Reginald Williams
	 */
	public static String capture(WebDriver driver, String screenshot) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = TestProperties.ReportsDirectory+"images"+File.separator+screenshot+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		
		return dest;
	}
}
