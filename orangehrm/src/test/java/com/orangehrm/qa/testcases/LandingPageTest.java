package com.orangehrm.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	 public static Logger log =LogManager.getLogger(TestBase.class.getName());


public LandingPageTest() {
	super();
}
	
@BeforeMethod()
public void setup() {
	initializeBrowser();
	log.info("Driver is Initiated");
	 LP = new LandingPage();
	FDP = new FreeDemoPage();
}

@Test(priority=1)
public void validatetitleTest() {
	String Title = LP.validatetitle();
	log.info("Title of landing page is validated");
	Assert.assertEquals(Title, "HR Management System | HR Management  | OrangeHRM");
}

@Test(priority=2)
public void validateLogoTest() {
	boolean flag = LP.validateLogo();
	Assert.assertTrue(flag);
	log.info("Logo is validated");

}

@Test(priority=3)
public void clickOnFreedemoTest() {
	FDP=LP.clickOnFreeDemo();
	log.info("Clicked on FreeDemoTest link");

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
	log.info("Browser closed");

}
	
}
