package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pricing {

	WebDriver driver;
	
	@FindBy(linkText = "Resources")
	public WebElement link_resources;
	
	@FindBy(xpath = "/html/body/header/div[2]/div/div/div/div[1]/div/div[1]/div[3]/div[1]/div[1]/div/div[2]")
	public WebElement submenu_resources;
	
	@FindBy(xpath = "//h1[text() = 'Products & Plans']")
	public WebElement verify_pricing;
	
	public Pricing(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
}
