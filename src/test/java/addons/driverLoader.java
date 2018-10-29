package addons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class driverLoader {

    public static WebDriver ffHeadless() {    	
  
		FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
      
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);        
        
        WebDriver nuevoDriver = new FirefoxDriver(firefoxOptions);
        
        return (nuevoDriver);
}
    public static WebDriver normal() {   		    
	    	 
    			FirefoxBinary firefoxBinary = new FirefoxBinary();	        
	      
	        FirefoxOptions firefoxOptions = new FirefoxOptions();
	        firefoxOptions.setBinary(firefoxBinary);        
	        
	    		WebDriver nuevoDriver = new FirefoxDriver(firefoxOptions);
	        
	        return (nuevoDriver);
	}
    
}