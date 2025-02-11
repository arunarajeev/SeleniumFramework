package test.java.com.learnAutomation.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.java.com.learnAutomation.pages.BaseClass;
import test.java.com.learnAutomation.pages.CRMLandingPage;
import test.java.com.learnAutomation.pages.LoginPage;
import test.java.com.learnAutomation.utility.BrowserFactory;
import test.java.com.learnAutomation.utility.ConfigDataProvider;
import test.java.com.learnAutomation.utility.Helper;

@Test
public class LoginTestCRM extends BaseClass{

	@Test
	public void loginApp() {
		extentTest = extentReports.createTest("Login to CRM");
		LoginPage loginpage = PageFactory.initElements(driver,LoginPage.class);
		extentTest.info("Starting Application");
		loginpage.loginToCRM(config.getDataFromConfig("email"),config.getDataFromConfig("password"));
		//loginpage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		extentTest.pass("Login Success");
	}
	
}
