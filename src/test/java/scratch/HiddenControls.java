package scratch;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.dc.pages.Page;
import com.dc.utilities.BaseLine;

public class HiddenControls extends BaseLine{
	
	WebDriver driver = getDriver();
	
	@Test
	public void check() {
	 //String sUrl = "https://video.eurosport.co.uk/tennis/atp-queen-s/2019/andy-murray-i-feel-lucky-to-be-playing-again_vid1210596/video.shtml";
	 //driver.get(sUrl);
	 
	 String xPath = "//*[@id=\"vjs_video_3\"]/div[7]/button[3]";
	 String xPath2 = "//*[@id=\"vjs_video_3\"]/div[7]";
	
	 
	WebElement wElement1 = driver.findElement(By.xpath(xPath));
	WebElement wElement2 = driver.findElement(By.xpath(xPath2));

	for(int x=1;x<=3;x++) {
		String strXPath = "//*[@id=\"vjs_video_3\"]/div[7]/button["+x+"]";
	
		WebElement wButton = driver.findElement(By.xpath(strXPath));
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String script = "arguments[0].click();";
		}
	
		HoverAndClick(driver,wElement2,wElement1);
	}
	
	
	public static void HoverAndClick(WebDriver driver,WebElement elementToHover,WebElement elementToClick) {
		 String xPath = "//*[@id=\"vjs_video_3\"]/div[7]/button[3]";
		 String xPath2 = "//*[@id=\"vjs_video_3\"]/div[7]";
		
		 
		 WebElement wElement1 = driver.findElement(By.xpath(xPath));
		 WebElement wElement2 = driver.findElement(By.xpath(xPath2));
		Actions action = new Actions(driver);
		action.moveToElement(elementToHover).click(elementToClick).build().perform();
	}
	
}
