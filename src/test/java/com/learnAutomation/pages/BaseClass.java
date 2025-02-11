package test.java.com.learnAutomation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.*;
import test.java.com.learnAutomation.utility.BrowserFactory;
import test.java.com.learnAutomation.utility.ConfigDataProvider;
import test.java.com.learnAutomation.utility.ExcelDataProvider;
import test.java.com.learnAutomation.utility.Helper;

@Test
public class BaseClass {
	//public ExcelDataProvider excel;
	
	public WebDriver driver;
	public ConfigDataProvider config;
	public ExtentReports extentReports;
	public ExtentTest extentTest;

	@Parameters({"browser","urlToBeTested"})
	@BeforeSuite
	public void setupSuite(String browser, String urlToBeTested) {
		Reporter.log("Test setup started", true);
		//excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentSparkReporter  extentSparkReporter = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM"+Helper.getCurrentDateTime()+".html"));

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		//configuration items to change the look and feel
		//add content, manage tests etc
		extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
		extentSparkReporter.config().setReportName("Test Report");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		System.out.println("Inside setUpSuite method");


		//driver = BrowserFactory.startApplication(driver,config.getBrowser().toString(),config.getURL().toString());
		driver = BrowserFactory.startApplication(driver,browser,urlToBeTested);
		
		Reporter.log("Test setup done.. good to start the tests", true);
	}


	@BeforeClass
	public void setup() {
		Reporter.log("Landing page setup done", true);
		//driver = BrowserFactory.startApplication(driver,"chrome", "https:\\www.freecrm.com");
		//
		CRMLandingPage landingPage = PageFactory.initElements(driver, CRMLandingPage.class);
		landingPage.goToLoginPage();	
		Object[] windowHandles=driver.getWindowHandles().toArray();
		System.out.println(windowHandles.length);
		driver.switchTo().window((String) windowHandles[1]);
		//assert on title of new window
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Cogmento CRM");
		Reporter.log("Switched to CRM login page", true);
	}
	@AfterMethod
	public void tearDownMethod(ITestResult result ) {
		if(result.getStatus() == ITestResult.FAILURE) {
			try {
				Helper.captureScreenshot(driver);
				extentTest.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
				System.out.println("Screenshot captured");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			extentTest.log(Status.FAIL,result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, result.getTestName());
			extentTest.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());			
		}
		else {
			extentTest.log(Status.SKIP, result.getTestName());
		}

	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	//	extentTest.fail("Failing on purpose");
		extentReports.flush();
		Reporter.log("Testing complete", true);
	}
}
