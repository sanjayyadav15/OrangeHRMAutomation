package com.orangehrm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.qa.utility.TestUtil;
import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.FreeDemoPage;
import com.orangehrm.qa.pages.LandingPage;

public class FreeDemoPageTest extends TestBase {
	
	LandingPage LP;
	FreeDemoPage FDP;
	TestUtil testUtil;
	
	String sheetName = "UserDetails";
public FreeDemoPageTest() {
	super();
}
	
@BeforeMethod()
public void setup() {
	initializeBrowser();
	log.info("browser is initiated");
	 LP = new LandingPage();
	FDP = new FreeDemoPage();
	testUtil = new TestUtil();
	FDP=LP.clickOnFreeDemo();
	
}

@Test(priority=1)
public void createUser() {
	
	FDP.createUser(prop.getProperty("FN"), prop.getProperty("LN"), prop.getProperty("EM"), prop.getProperty("PH"), prop.getProperty("CN"),prop.getProperty("ST"));
  log.info("Create User method executed");
}

@DataProvider
public Object[][] getOrangeTestData(){
	log.info("Data Provider called");

	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
}


@Test(priority=1,dataProvider="getOrangeTestData")
public void createMultiUser(String FN, String LN,String EM, String PH,String CN, String ST) {
	
	FDP.createUser(FN, LN, EM, PH, CN, ST);
	log.info("Login with"+FN);

}

@AfterMethod()
public void tearDown() {
	driver.quit();
	log.info("browser closed");
}

}
