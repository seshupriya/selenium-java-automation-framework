package config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import genericUtility.PropertyUtility;
import genericUtility.WebDriverUtility;
import pom.AssignmentLoginPage;

public class assignmentbaseclass {
	public WebDriver driver=null;
	public PropertyUtility plib=new PropertyUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	
	@BeforeSuite
	public void beforesuite() {
		Reporter.log("Datebase connectivity--beforesuite",true);
	}
	@AfterSuite
	public void aftersuite() {
		Reporter.log("closing Datebase connectivity--beforesuite",true);
	}

	@BeforeClass
	public void beforeclass() throws IOException {
		String BROWSER = plib.toReadDataFromPropertyFile("browser");
	     if(BROWSER.equals("chrome")){
	    	 ChromeOptions settings = new ChromeOptions(); 
	 		Map<String, Object> prefs = new HashMap<>(); 
	 		prefs.put("profile.password_manager_leak_detection", false); 
	 		settings.setExperimentalOption("prefs", prefs); 
	 		driver=new ChromeDriver(settings);
	     }else if(BROWSER.equals("firefox")) {
	    	 driver=new FirefoxDriver();
	     }
		
	     wlib.maximize(driver);
			wlib.implicitWait(driver); 
	}
	@AfterClass(groups = "smoke")
	public void afterclass() {
		driver.quit();
		
		}
	@BeforeMethod
	public void beforemethod() throws IOException {
		String URL = plib.toReadDataFromPropertyFile("assignment_url");
		String USERNAME = plib.toReadDataFromPropertyFile("assignment_username");
		String PASSWORD = plib.toReadDataFromPropertyFile("assignment_password");
		driver.get(URL);
	    wlib.ApplicationUrl(driver, URL);  
		AssignmentLoginPage lp=new AssignmentLoginPage(driver);
		lp.getuN().sendKeys(USERNAME);
		lp.getpWD().sendKeys(PASSWORD);
		lp.getLoGin().click();
	}
	@AfterMethod
	
	public void aftermethod() {
		Reporter.log("aftermethod",true);
	}

	@BeforeTest(groups = "smoke")
	public void beforetest() {
		Reporter.log("Parallel--beforetest",true);
	}
	@AfterTest(groups = "smoke")
	public void aftertest() {
		Reporter.log("Parallel--aftertest",true);
	}
}
