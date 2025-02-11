package test.java.com.learnAutomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.time.format.*;
public class Helper {
 	WebDriver driver;
	public static String captureScreenshot(WebDriver driver) {
		String screenshotPath = System.getProperty("user.dir")+"./Screenshots/"+"FreeCRM_"+getCurrentDateTime()+".png";
		try {
			System.out.println("Inside captureScreenshot method");
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
			//String path = "SS_"+getCurrentDateTime()+".png";	
			FileHandler.copy(src, new File(screenshotPath));
		} catch (Exception e) {
			System.out.println("Screenshot not saved "+ e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		SimpleDateFormat ft 
        = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss"); 
		String str = ft.format(new Date()); 
		//System.out.println("Screenshot file name "+str+"   --Aruna");
		return str;
	}

}
