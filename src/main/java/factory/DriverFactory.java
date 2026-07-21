package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/***
 * for Driver Selection
 */
public class DriverFactory {

	
	
	public static WebDriver initializeDriver(String browserName) {
		
		if(browserName.equalsIgnoreCase("firefox")) {
			
			return new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			
			return new EdgeDriver();
		}
		else return new ChromeDriver();
	}
}
