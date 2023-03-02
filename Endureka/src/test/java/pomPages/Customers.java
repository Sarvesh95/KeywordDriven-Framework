package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customers {

	
	WebDriver driver;
	@FindBy(linkText = "Pricing")
	public WebElement link_pricing;
	
	@FindBy(xpath = "//h1[text() = 'Customer First is in our DNA']")
	public WebElement verify_Customers;
	
	public Customers(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
}
