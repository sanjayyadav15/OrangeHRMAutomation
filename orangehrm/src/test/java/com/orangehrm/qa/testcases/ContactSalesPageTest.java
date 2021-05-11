package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.ContactSalesPage;
import com.orangehrm.qa.pages.LandingPage;

public class ContactSalesPageTest extends TestBase{
	ContactSalesPage CS;
	LandingPage LP;

	
	public ContactSalesPageTest() {
		super();
	}
	
	@BeforeMethod()
	public void setup() {
		initializeBrowser();
		 LP = new LandingPage();
		 CS = new ContactSalesPage();
		 CS= LP.getContactSalesPage();
	}
	
	@Test(priority=1)
	public void validateSocialMediaImageTest() {
		boolean flag =CS.checkSocialMedia();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void clickOnBlogTest() {
		CS.clickBlog();
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

	
	
}
