package test.java.com.learnAutomation.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import test.java.com.learnAutomation.utility.BrowserFactory;

@Test
public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver){
		this.driver = ldriver;
	}
	
	@FindBy(name="email") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//div[contains(@class,'submit')]") WebElement loginButton;
	
	public void loginToCRM(String username, String password) {
		uname.sendKeys(username);
		pass.sendKeys(password);
		loginButton.click();
	}
	
	

}
