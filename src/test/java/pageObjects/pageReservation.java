package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class pageReservation {
	private WebDriver driver;
	private By reservationText;
	
	public pageReservation(WebDriver driver) {
		this.driver = driver;
		reservationText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
	}
	
	public void assertReservationText() {
		Assert.assertTrue(driver.findElement(reservationText).getText().contains("Flight Finder"));
	}
}
