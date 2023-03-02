package casestudy2;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirefoxTest extends TestBase {

	
		Utilities util;
		
		WebDriverWait wait;
		
		@BeforeTest
		public void setUp() throws MalformedURLException {
			
			driver=initialize("firefox");
		}
		
		@Test
		public void testfilpkart() throws InterruptedException {
			util = new Utilities(driver);
			driver.get("https://www.flipkart.com");
			Thread.sleep(2000);
			util.click("//button[@class='_2KpZ6l _2doB4z']", driver);
			util.click("//*[@id=\"container\"]/div/div[2]/div/div/div[2]", driver);
			util.selectsubmenu("//span[text()='Electronics']","//*[@id=\"container\"]/div/div[2]/div/div/div/div[1]/a[2]", driver);
			Thread.sleep(3000);
			String Actualtext = driver.findElement(By.xpath("//h1[text()='Mi Mobiles']")).getText();
			util.verifytext(Actualtext, "Mi Mobiles", driver);
			
			
		}
		
		@AfterTest
		public void tearDown() {
			
			driver.close();
			
			driver.quit();
		}
}
