package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class pageSignon {
	private WebDriver driver;
	private By welcomeText;
	
	public pageSignon(WebDriver driver) {
		this.driver = driver;
		welcomeText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b");
		
	}
	
	public void assertSignonPage() {
		Assert.assertTrue(driver.findElement(welcomeText).getText().contains("Welcome back to"));
	}

}
