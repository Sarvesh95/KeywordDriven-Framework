package casestudy2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor.ForReplacement;

public class  ChromeTest extends TestBase {

	String storeText;
	Utilities util;
	WebDriverWait wait;
	SoftAssert soft;
	Actions act;
	Robot rob;
	@BeforeTest
	public void setUp() throws MalformedURLException {
		
		driver=initialize("chrome");
		
	
	}
	
	
	@Test
	public void testfilpkart() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		util = new Utilities(driver);
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		util.click("//button[@class='_2KpZ6l _2doB4z']", driver);
		util.click("//*[@id=\"container\"]/div/div[2]/div/div/div[2]", driver);
		util.selectsubmenu("//span[text()='Electronics']","//*[@id=\"container\"]/div/div[2]/div/div/div/div[1]/a[2]", driver);
		Thread.sleep(2000);
		String Actualtext = driver.findElement(By.xpath("//h1[text()='Mi Mobiles']")).getText();
		util.verifytext(Actualtext, "Mi Mobiles", driver);
		Thread.sleep(2000);
		util.slider("//section[@class='_2yz7eI _2hbLCH']/div[3]/div/div/div", 50, 0, driver);
		util.slider("//section[@class='_2yz7eI _2hbLCH']/div[3]/div/div[2]/div", -40, 0, driver);
		util.Dropdownselect("//section[@class='_2yz7eI _2hbLCH']/div[4]/div[3]/select", "₹30000", driver);
		util.type("redmi note 10", "//input[@class='_3704LK']", driver);
		util.submit("//button[@class='L0Z3Pu']", driver);
		util.click("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[1]/div[1]/div/div/img", driver);
		util.switchWindow();
		storeText = util.getText("//div[@class='_30jeq3 _16Jk6d']", driver);
		String regex = "[^\\d.]";
		String newText = storeText.replaceAll(regex, "");
		System.out.println(newText);
		int value= Integer.parseInt(newText);
		System.out.println(value);
		soft = new SoftAssert();
		if(value>=0) {
			soft.assertTrue(true, "the price value is greater then 0");
		}else {
			soft.assertTrue(false, "price value is less then 0");
		}
		util.click("//input[@placeholder='Enter Delivery Pincode']", driver);
		Thread.sleep(3000);
		 rob = new Robot();
		 
		 rob.keyPress(KeyEvent.VK_4);
		 rob.keyRelease(KeyEvent.VK_4);
		 rob.keyPress(KeyEvent.VK_0);
		 rob.keyRelease(KeyEvent.VK_0);
		 rob.keyPress(KeyEvent.VK_3);
		 rob.keyRelease(KeyEvent.VK_3);
		 rob.keyPress(KeyEvent.VK_5);
		 rob.keyRelease(KeyEvent.VK_5);
		 rob.keyPress(KeyEvent.VK_1);
		 rob.keyRelease(KeyEvent.VK_1);
		 rob.keyPress(KeyEvent.VK_3);
		 rob.keyRelease(KeyEvent.VK_3);
		 rob.keyPress(KeyEvent.VK_ENTER);
		 rob.keyRelease(KeyEvent.VK_ENTER);
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[7]/div/div/div[2]/div[2]/span"))).click();
		 WebElement ele = driver.findElement(By.xpath("//span[@class='YxlyDn']"));
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", ele);
		storeText = util.getText("//span[text()='Delivery & Installation details']", driver);
		System.out.println("expected result is "+storeText);
		soft.assertEquals("Delivery & Installation details", storeText,"Modal pop-up has been opened");
		soft.assertAll();
		WebElement ele1 =driver.findElement(By.xpath("//button[@class='_2KpZ6l _1KAjNd']"));
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click();", ele1);
		util.click("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']", driver);
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
		
		driver.quit();
	}
}
