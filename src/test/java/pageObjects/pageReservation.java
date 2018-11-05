package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class pageReservation {
	private WebDriver driver;
	private By reservationText;
	private By passengersDrop;
	private By fromDrop;
	private By startMonthDrop;
	private By startDayDrop;
	private By toDrop;
	private By endMonthDrop;
	private By endDayDrop;
	private By continueButton;
	private By reservationText2;
	
	public pageReservation(WebDriver driver) {
		this.driver = driver;
		reservationText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
		passengersDrop = By.name("passCount");
		fromDrop = By.name("fromPort");
		startMonthDrop = By.name("fromMonth");
		startDayDrop = By.name("fromDay");
		toDrop = By.name("toPort");
		endMonthDrop = By.name("toMonth");
		endDayDrop = By.name("toDay");
		continueButton = By.name("findFlights");
		reservationText2 = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
		
	}
	
	public void assertReservationText() {
		Assert.assertTrue(driver.findElement(reservationText).getText().contains("Flight Finder"));
	}
	
	public void selectPassengers (int cant) {
		Select selectPasajeros = new Select(driver.findElement(passengersDrop));
		selectPasajeros.selectByVisibleText(Integer.toString(cant));
	}
	
	public void selectFrom (String place) {
		Select selectDesde = new Select(driver.findElement(fromDrop));
		selectDesde.selectByVisibleText(place);
	}
	
	public void selectStartDate (String month, int day) {
		Select selectMes = new Select(driver.findElement(startMonthDrop));
		selectMes.selectByVisibleText(month);
		Select selectDia = new Select(driver.findElement(startDayDrop));
		selectDia.selectByValue(Integer.toString(day));
	}
	
	public void selectTo (String place) {
		Select selectHasta = new Select(driver.findElement(toDrop));
		selectHasta.selectByVisibleText(place);
	}
	
	public void selectEndDate (String month, int day) {
		Select selectMes = new Select(driver.findElement(endMonthDrop));
		selectMes.selectByVisibleText(month);
		Select selectDia = new Select(driver.findElement(endDayDrop));
		selectDia.selectByValue(Integer.toString(day));		
	}
	
	public void submitReservation() {
		driver.findElement(continueButton).click();
	}
	
	public void assertReservationText2() {
		Assert.assertTrue(driver.findElement(reservationText2).getText().contains("Select your departure"));
	}
}
