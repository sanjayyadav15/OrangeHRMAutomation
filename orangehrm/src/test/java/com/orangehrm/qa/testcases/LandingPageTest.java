package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.FreeDemoPage;
import com.orangehrm.qa.pages.LandingPage;

public class LandingPageTest extends TestBase{
	LandingPage LP;
	FreeDemoPage FDP;
public LandingPageTest() {
	super();
}
	
@BeforeMethod()
public void setup() {
	initializeBrowser();
	 LP = new LandingPage();
	FDP = new FreeDemoPage();
}

@Test(priority=1)
public void validatetitleTest() {
	String Title = LP.validatetitle();
	Assert.assertEquals(Title, "HR Management System | HR Management  | OrangeHRM");
}

@Test(priority=2)
public void validateLogoTest() {
	boolean flag = LP.validateLogo();
	Assert.assertTrue(flag);
}

@Test(priority=3)
public void clickOnFreedemoTest() {
	FDP=LP.clickOnFreeDemo();
}

/*@Test(priority=4)
public void createUserTest() {
	LP.clickOnFreeDemo();
	FDP.createUser(prop.getProperty("FN"), prop.getProperty("LN"), prop.getProperty("EM"), prop.getProperty("PH"), prop.getProperty("CN"),prop.getProperty("ST"));
}
*/
@AfterMethod()
public void tearDown() {
	driver.quit();
}
	
}
