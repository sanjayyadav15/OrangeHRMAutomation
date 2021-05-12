package com.orangehrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.orangehrm.qa.utility.TestUtil;

@SuppressWarnings("deprecation")
public class TestBase {
	
	public static WebDriver driver;
	public	static Properties prop;
	 public static Logger log =LogManager.getLogger(TestBase.class.getName());

	//public  static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;


	
		
		public TestBase() {
			
			prop=new Properties();
			
			try {
				FileInputStream ip=new FileInputStream("F:\\OrangeHRMAutomation\\orangehrm\\src\\main\\java\\com\\orangehrm\\qa\\config\\config.properties");
				prop.load(ip);
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
	public static void initializeBrowser() {
	String BrowserName = prop.getProperty("browser");
	if(BrowserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "F:\\OrangeHRMAutomation\\orangehrm\\src\\main\\java\\com\\orangehrm\\qa\\testdata\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
	else if(BrowserName.equals("firefox")) {
		System.setProperty("webdriver.geco.driver", "F:\\OrangeHRM_Automation_Suite\\orangehrm\\src\\main\\java\\com\\orangehrm\\qa\\testdata\\chromedriver.exe");
		 driver = new FirefoxDriver();
	}
	// it is for printing webdriver message in console
	//e_driver = new EventFiringWebDriver(driver);
	//eventListener = new WebEventListener();

	//e_driver.register(eventListener);
	//driver = e_driver;
	
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEUNIT,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
	}
}
