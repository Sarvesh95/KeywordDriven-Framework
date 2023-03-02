package casestudy3a;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonUtilities {

	WebDriver driver;
	
	public CommonUtilities(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public boolean performActions(String keyword, String locatorType, String locatorValue, Object  data) throws InterruptedException {
		
		if(keyword.equalsIgnoreCase("CLICK")) {
			
			driver.findElement(this.getObject(locatorType, locatorValue)).click();
			
			return true;						
		}else if(keyword.equalsIgnoreCase("ENTER_TEXT")) {
			
			driver.findElement(this.getObject(locatorType, locatorValue)).sendKeys( (String) data);
			
			return true;		
			
		}if(keyword.equalsIgnoreCase("OPEN_URL")) {
			
			driver.get((String) data);
			
			return true;
			
		}if(keyword.equalsIgnoreCase("VERIFY_TEXT")) {
			
			  String datas    =  String.valueOf(data);
			String Actualdata =	driver.findElement(this.getObject(locatorType, locatorValue)).getText();
					
					Assert.assertEquals(Actualdata, datas);
					
					System.out.println("The total count of the Product is "+Actualdata);
			
								
		}else if(keyword.equalsIgnoreCase("PRINT_TEXT")) {
			
			String Text = driver.findElement(this.getObject(locatorType, locatorValue)).getText();
			
			System.out.println("the text verified is : "+Text);
			
			return true;	
			
		}else if(keyword.equalsIgnoreCase("CLOSE_BROWSER")) {
			
			driver.close();
			
			return true;						
		}else if(keyword.equalsIgnoreCase("sleep")) {
		
		         String strconv = String.valueOf(data);
		        Long longval = Long.valueOf(strconv);
			Thread.sleep( longval);
			
			System.out.println("adding a sleep timer");
			return true;						
		}
		
		return false;
	}
	
	
	public By getObject(String locatorType, String locatorValue) {
		
		if(locatorType.equalsIgnoreCase("xpath")) {
			
			return By.xpath(locatorValue);
		}else if(locatorType.equalsIgnoreCase("id")) {
			
			return By.id(locatorValue);
		} else if(locatorType.equalsIgnoreCase("css")) {
			
			return By.cssSelector(locatorValue);
		}else if(locatorType.equalsIgnoreCase("name")) {
			
			return By.name(locatorValue);
		}else if(locatorType.equalsIgnoreCase("classname")) {
			
			return By.className(locatorValue);
		}else if(locatorType.equalsIgnoreCase("link")) {
			
			return By.linkText(locatorValue);
		}else if(locatorType.equalsIgnoreCase("partiallink")) {
			
			return By.partialLinkText(locatorValue);
			
		}
		return null;
			
			
	}
	
}

