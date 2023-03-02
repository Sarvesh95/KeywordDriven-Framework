package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resources {

	WebDriver driver;
	
	@FindBy(linkText = "Company")
	public WebElement company_hover;
	
	@FindBy(xpath = "//p[text() = 'RESOURCES']")
	public WebElement verify_resources;
	
	@FindBy(xpath = "/html/body/header/div[2]/div/div/div/div[1]/div/div[1]/div[3]/div/div/div/div[4]/a/div/div")
	public WebElement submenu_partners;
	

	
	public Resources(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
}
