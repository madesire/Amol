package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshots {
	public static void screenshotcapture(WebDriver driver, String FileName){
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File destFile = new File("./screenshots/"+FileName);
		try {
			FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), destFile);
		} catch (Exception e) {
			System.out.println("Screenshot captured sucessfully");
		}
	}
	public static String captureScreenShotWithPath(WebDriver driver, String filename) throws IOException {
		// TODO Auto-generated method stub
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		 File source = ts.getScreenshotAs(OutputType.FILE);	
		String path = System.getProperty("user.dir")+"\\screenshots\\"+filename+".png";		 
		File destination = new File(path);
		
		FileHandler.copy(source, destination);
		
		return path;
	}

}
