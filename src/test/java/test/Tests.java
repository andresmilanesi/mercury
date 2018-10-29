package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
