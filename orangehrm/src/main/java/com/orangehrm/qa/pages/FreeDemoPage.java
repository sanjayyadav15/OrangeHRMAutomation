package com.orangehrm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.qa.base.TestBase;

public class FreeDemoPage extends TestBase {

	@FindBy(xpath="//input[@id='Form_submitRequest_FirstName']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='Form_submitRequest_LastName']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@id='Form_submitRequest_Email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='Form_submitRequest_Phone']")
	WebElement Phone;
	
	@FindBy(xpath="//select[@id='Form_submitRequest_Country']")
	WebElement Country;
	
	@FindBy (xpath="//select[@id='Form_submitRequest_State']")
	WebElement State;
	
	@FindBy(xpath="//div[@id='Form_submitRequest_Captcha_Holder']")
	WebElement Captcha;
	
	
	public FreeDemoPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createUser(String FN, String LN,String EM,String PH,String CN, String ST ) {
		FirstName.sendKeys(FN);
		LastName.sendKeys(LN);
		Email.sendKeys(EM);
		Phone.sendKeys(PH);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		jse.executeScript("arguments[0].scrollIntoView();", Country);//it will scroll down until the element found
		Select s = new Select(Country);
		s.selectByValue(CN);
		
		Select st = new Select(State);
		st.selectByValue(ST);
		
		Captcha.click();
		
	}
	
	
}
