package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import addons.driverFinder;
import addons.driverLoader;
import pageObjects.pageLogin;
import pageObjects.pageReservation;
import pageObjects.pageSignon;

public class Tests {
	private WebDriver driver;
	@BeforeMethod
	public void setUp() {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.gecko.driver", driverFinder.findFirefoxDriver().get());
		driver = driverLoader.ffHeadless();//.ffHeadless();//.normal()
		driver.manage().window().maximize();
		driver.navigate().to("http://newtours.demoaut.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void loginFail() {
		pageLogin pageLogin = new pageLogin(driver);
		pageLogin.login("user", "user");
		pageSignon pageSignon = new pageSignon(driver);
		pageSignon.assertSignonPage();
	}
	@Test
	public void loginPass() {
		pageLogin pageLogin = new pageLogin(driver);
		pageLogin.login("mercury", "mercury");
		pageReservation pageReservation = new pageReservation(driver);
		pageReservation.assertReservationText();
	}
	//Test a flight reservation
	@Test
	public void flightReservation() {
		pageLogin pageLogin = new pageLogin(driver);
		pageLogin.login("mercury", "mercury");
		pageReservation pageReservation = new pageReservation(driver);
		pageReservation.selectPassengers(2);
		pageReservation.selectFrom("London");
		pageReservation.selectStartDate("April", 1);
		pageReservation.selectTo("Paris");
		pageReservation.selectEndDate("December", 1);
		pageReservation.submitReservation();
		pageReservation.assertReservationText2();		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(!result.isSuccess()) {
			File myScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(myScreenshot, new File("Error "+System.currentTimeMillis()+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		driver.close();
	}
}
