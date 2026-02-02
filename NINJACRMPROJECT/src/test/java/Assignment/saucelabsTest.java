package Assignment;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import config.assignmentbaseclass;
import pom.AssignmentProductPage;
@Listeners(listener.ListenerImplementation.class)
public class saucelabsTest extends assignmentbaseclass{
	@Test
	public void purchaseProductTest() throws IOException {	
		AssignmentProductPage APP=new AssignmentProductPage(driver);
		APP.getProductName().click();
		APP.getCartLink().click();
		APP.getCheckOutBtn().click();
		wlib.waitForElementToBeVisible(driver, APP.getFirstName());
		APP.getFirstName().sendKeys("Seshupriya");
		APP.getLastName().sendKeys("p");
		APP.getPostalCode().sendKeys("570008");
		APP.getContinueBtn().click();
		APP.getFinishBtn().click();
		TakesScreenshot ts=(TakesScreenshot) driver;
        File temp=ts.getScreenshotAs(OutputType.FILE);
        File perm=new File("././Screenshot/thankyou.png");
        FileHandler.copy(temp,perm);
		
	
		
}
}
