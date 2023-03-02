package casestudy2;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	WebDriver driver;
	

	public WebDriver initialize(String browsername) throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		if(browsername.equalsIgnoreCase("chrome")) {
			
			dc.setBrowserName("chrome");
		}else if(browsername.equalsIgnoreCase("firefox")) {
			
			dc.setBrowserName("firefox");
		}else if(browsername.equalsIgnoreCase("edge")) {
			
			dc.setBrowserName("MicrosoftEdge");
		}else if(browsername.equalsIgnoreCase("opera")){
			
			dc.setBrowserName("opera");
		}else {
			
			System.out.println("not a valid browser");
		}
		
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), dc);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));	    
		driver.manage().window().maximize();
		return driver;
	}
	
	
}
