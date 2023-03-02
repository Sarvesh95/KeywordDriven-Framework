package casestudy2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Utilities {

	
	SoftAssert soft;
	Actions act;
	WebDriver driver;
	WebDriverWait wait;
	
	public Utilities(WebDriver driver) {
		this.driver = driver;
	}
	public void click(String locator, WebDriver driver) {
		
		driver.findElement(By.xpath(locator)).click();
	}
	
	public void type(String keyword, String locator, WebDriver driver) {
		
		driver.findElement(By.xpath(locator)).sendKeys(keyword);
	}
	
	public void selectsubmenu(String locator1,String locator2, WebDriver driver) {
		
		WebElement ele = driver.findElement(By.xpath(locator1));
		act = new Actions(driver);
		
		act.moveToElement(ele).perform();
		WebElement ele1 = driver.findElement(By.xpath(locator2));
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ele1));
		act.moveToElement(ele1).click().perform();
	}

	public void copyandpaste(String text, String locator, WebDriver driver) throws AWTException {
		
		StringSelection sel = new StringSelection(text);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		
		Robot rob = new Robot();
		
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_V);
	}
	
	public void verifytext(String Actualtitle, String Expectedtitle,  WebDriver driver) {
		
		soft = new SoftAssert();
		
		soft.assertEquals(Actualtitle, Expectedtitle);
		soft.assertAll();
		
	}
	
	public void hover(String locator, WebDriver driver) {
		WebElement ele = driver.findElement(By.id(locator));
		act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		
		
	}
	
	public void slider(String locator, int offset1, int offset2, WebDriver driver) throws InterruptedException {
		
		WebElement w = driver.findElement(By.xpath(locator));
		act = new Actions(driver);
		act.dragAndDropBy(w, offset1, offset2).perform();
		Thread.sleep(1000);
	}
	
	public void Dropdownselect(String locator, String text,WebDriver driver) {
		
		WebElement wb = driver.findElement(By.xpath(locator));
		Select select = new Select(wb);
		
		select.selectByVisibleText(text);
		
	}
	
	public void submit(String locator, WebDriver driver) {
		
		driver.findElement(By.xpath(locator)).submit();
	}
	
	public String  getText(String locator, WebDriver driver) {
		String Text = driver.findElement(By.xpath(locator)).getText();
		
		return Text;
	}
	
	public void switchWindow() throws InterruptedException {
		Thread.sleep(2000);
		String OriginalWindow = driver.getWindowHandle();
		
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!OriginalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
	  }
   
  }
	
}

