package testDefinations;

import org.openqa.selenium.WebDriver;

import frameworkUtility.FuncLibrary;
import frameworkUtility.FutilLibrary;
import io.cucumber.java.en.*;
import pomPages.Customers;
import pomPages.Home;
import pomPages.Partners;
import pomPages.Pricing;
import pomPages.Resources;

public class WhatfixStepDefination extends FuncLibrary {
    WebDriver driver;
 
 
	
	
	
	@Given("^browser is open$")
	public void browser_is_open() {
	 
		driver =startBrowser();
	 
	}

	@And("^user is on the home page$")
	public void user_is_on_the_home_page() {
		
		launchURL();
		
		
	}

	@When("^User clicks on the Customers link$")
	public void user_clicks_on_the_customers_link() {
	    
		Home hm = new Home(driver);
		eleClick(hm.link_customers);
	}

	@Then("^verify that user is navigated to the customers Page$")
	public void verify_that_user_is_navigated_to_the_customers_page() {
		FutilLibrary futil = new FutilLibrary();
		Customers cu = new Customers(driver);
		verifyText(cu.verify_Customers, futil.readProperty("verify_customer"));
		
		
	}

	@When("^User clicks on the Pricing link$")
	public void user_clicks_on_the_pricing_link() {
		
		Customers cu = new Customers(driver);
		eleClick(cu.link_pricing);
	}

	@Then("^verify that user is navigated to the Pricing page$")
	public void verify_that_user_is_navigated_to_the_pricing_page() {
		FutilLibrary futil = new FutilLibrary();
		Pricing price = new Pricing(driver);
		verifyText(price.verify_pricing, futil.readProperty("verify_pricing"));
	}

	@When("^User clicks on the Resources link$")
	public void user_clicks_on_the_resources_link() {
	  
		Pricing price = new Pricing(driver);
		selectsubmenu(price.link_resources, price.submenu_resources);
		
	}

	@Then("^verify that user is navigated to the Resources page$")
	public void verify_that_user_is_navigated_to_the_resources_page() {
		FutilLibrary futil = new FutilLibrary();
		Resources res = new Resources(driver);
		verifyText(res.verify_resources, futil.readProperty("verify_resources"));
	}

	@When("^User clicks on the Partners link$")
	public void user_clicks_on_the_partners_link() {
	    
		
		Resources res = new Resources(driver);
		selectsubmenu(res.company_hover, res.submenu_partners);
	}
	
	@Then("^verify that user is navigated to the Partners page$")
	public void verify_that_user_is_navigated_to_the_partners_page() {
		FutilLibrary futil = new FutilLibrary();
		Partners partn = new Partners(driver);
		verifyText(partn.verify_partners, futil.readProperty("verify_partners"));
		
		sleep(3000);
		
	driver.close();
	
	driver.quit();
	}

}
