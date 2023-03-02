package casestudy3a;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;

public class DriverManager {

	WebDriver driver;
	public WebDriver setDriver(String browserName) {
		
		switch(browserName) {
		
		case "chrome":
			
			driver = initChromeDriver();
			
			break;
			
		case "firefox":
			
			driver = initFirefoxDriver();
			
			break;
			
		case "edge"	:
			
			driver = initEdgeDriver();
			
			break;
			
		case "IE" :
			
			driver = IEDriver();
			
			break;
		}
		
		return driver;
	}
	
	public WebDriver initChromeDriver() {
		
		WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		
		return driver;
	}
	
	public WebDriver initFirefoxDriver() {
		
		WebDriverManager.firefoxdriver().setup();
		
		driver = new FirefoxDriver();
		
		return driver;
	}
	
	public WebDriver initEdgeDriver() {
		
		WebDriverManager.edgedriver().setup();
		
		driver = new EdgeDriver();
		
		return driver;
	}
	
   public WebDriver IEDriver() {
	   
	   WebDriverManager.iedriver().setup();
	   
	   driver = new InternetExplorerDriver();
	   
	   return driver;
   }
}
