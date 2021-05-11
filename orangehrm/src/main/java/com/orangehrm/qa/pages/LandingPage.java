package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;

public class LandingPage extends TestBase {
	// page factory OR(object Repository)
	@FindBy(xpath="// button[@class='demo-btn home-btn trial-btn pulse']")
	WebElement GetFreeDemo_Button ;
	
	@FindBy (css = "body.pc.pace-done:nth-child(2) nav.navbar.navbar-default.header-nav:nth-child(6) div.container div.collapse.navbar-collapse ul.nav.navbar-nav.navbar-right.extended-nav:nth-child(3) li.ex-nav:nth-child(2) > a.btn-orange.contact-ohrm")
	WebElement Free30Daytrial_button ;
	
    @FindBy(xpath="//a[contains(text(),'Contact Sales')]")
    WebElement ContactSales_Button;
    
    @FindBy(xpath="//body/nav[1]/div[1]/div[1]/a[1]/img[1]")
    WebElement HRMLogo;
    //Initializing the page Object
    public LandingPage() {
    	
    	PageFactory.initElements(driver, this);
    	
    }
    
    //Actions on landing page
    
    public String validatetitle() {
    	return driver.getTitle();
    }
    
    public boolean validateLogo(){
    	return HRMLogo.isDisplayed();
    	
    }
    
    public FreeDemoPage clickOnFreeDemo() {
    	GetFreeDemo_Button.click();
    	return new FreeDemoPage() ;
    }
    
    public ContactSalesPage getContactSalesPage() {
    	ContactSales_Button.click();
    	return new ContactSalesPage();
    }

	 
}

