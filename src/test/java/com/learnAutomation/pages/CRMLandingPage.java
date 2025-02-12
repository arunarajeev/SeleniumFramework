package test.java.com.learnAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

@Test
public class CRMLandingPage {

	WebDriver driver;

	public CRMLandingPage(WebDriver ldriver){
		this.driver = ldriver;
	} 

	@FindBy(xpath="//a[text()='Login']") WebElement landingPageLoginButton;
	public void goToLoginPage() {
		landingPageLoginButton.click();
	}
}
