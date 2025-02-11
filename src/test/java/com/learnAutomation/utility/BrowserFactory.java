package test.java.com.learnAutomation.utility;

import java.time.Duration;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		System.out.println("Browser name read from config.properties file is "+ browserName);
		
		if(browserName.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName == "edge"){
			System.setProperty("webdriver.edge.driver", ".\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("We do not support this browser !!");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get(appURL);	
		driver.manage().window().maximize();	
		return driver;
	}
	public static void quitBrowser(WebDriver driver) {
		
		driver.quit();
	}
}
