package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;

public class ContactSalesPage extends TestBase {

	@FindBy(xpath="//h5[contains(text(),'Social Media:')]")
	WebElement SocialMedia;
	
	@FindBy(xpath="//body/footer[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")
	WebElement Blog;
	
	public ContactSalesPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean checkSocialMedia() {
		return SocialMedia.isDisplayed();
	}
	
	public void clickBlog() {
		Blog.click();
	}
}
