package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pageLogin {
	private WebDriver driver;
	private By userField;
	private By passField;
	private By signinButton;
	
	public pageLogin(WebDriver driver) {
		this.driver= driver;
		userField = By.name("userName");
		passField = By.name("password");
		signinButton = By.name("login");
	}
	
	public void login(String user, String pass) {
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passField).sendKeys(pass);
		driver.findElement(signinButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
