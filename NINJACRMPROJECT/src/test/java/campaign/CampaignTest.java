package campaign;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import config.baseclass;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pom.CreateCampaignPage;
import pom.HomePage;
@Listeners(listener.ListenerImplementation.class)
public class CampaignTest extends baseclass {
	@Test(groups = "smoke")
	public void createCampaignWithMandatoryFieldTest() throws IOException {


		String CAMPAIGNNAME = elib.toReadDataFromExcelFile("Campaign", 1, 0);
		String TARGETSIZE = elib.toReadDataFromExcelFile("Campaign", 1, 1);
		//Create campaign with manadatory details
		//homepage
		HomePage hp=new HomePage(driver);
		hp.getCREATECAMPAIGNWE().click();
        
        //CreateCampaignPage
        CreateCampaignPage ccp=new CreateCampaignPage(driver);
		String cp= CAMPAIGNNAME + jlib.RandomAlphabet();
		ccp.getCAMPAIGNNAMEWE().sendKeys(cp); 
		WebElement ts = ccp.getTARGETSIZEWE(); 
		ts.clear(); 
		ts.sendKeys(TARGETSIZE); 
		ccp.getCREATECAMPAIGNBUTTONWE().click();
		
		//Validation of create campaign
		WebElement toastmsg=hp.getTOASTMSGWE();
		wlib.waitForElementToBeVisible(driver,toastmsg);
		String msg = toastmsg.getText();
		Assert.assertEquals(msg, "Campaign " + cp + " Successfully Added");
		WebElement toastclose = hp.getTOASTCLOSE();
		wlib.waitForElementToBeInvisible(driver, toastclose);
	}
	@Test
	public void createCampainWithStatusTest() throws EncryptedDocumentException, IOException {
		
		
		String CAMPAIGNNAME = elib.toReadDataFromExcelFile("Campaign", 1, 0);
		String TARGETSIZE = elib.toReadDataFromExcelFile("Campaign", 1, 1);
		String STATUS = elib.toReadDataFromExcelFile("Campaign", 1, 2);
		
		//Create campaign with status
		
		HomePage hp=new HomePage(driver);
		hp.getCREATECAMPAIGNWE().click();
		
		//CreateCampaignPage
        CreateCampaignPage ccp=new CreateCampaignPage(driver);
		String cp = CAMPAIGNNAME + jlib.RandomAlphabet();
	    ccp.getCAMPAIGNNAMEWE().sendKeys(cp); 
	    ccp.getSTATUSWE().sendKeys(STATUS);
		WebElement ts = ccp.getTARGETSIZEWE(); 
		ts.clear(); 
	    ts.sendKeys(TARGETSIZE); 
		ccp.getCREATECAMPAIGNBUTTONWE().click();
		
		
		//Validation of create campaign with status
				WebElement toastmsg=hp.getTOASTMSGWE();
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(toastmsg));
				String msg = toastmsg.getText();
				Assert.assertEquals(msg, "Campaign " + cp + " Successfully Added");
				WebElement toastclose = hp.getTOASTCLOSE();
				wlib.waitForElementToBeInvisible(driver, toastclose);
				
	}
	@Test(groups = "smoke")
	public void createCampaignWithExpectedDateTest() throws EncryptedDocumentException, IOException {
		
		String CAMPAIGNNAME = elib.toReadDataFromExcelFile("Campaign", 1, 0);
		String TARGETSIZE = elib.toReadDataFromExcelFile("Campaign", 1, 1);
		
		//Create campaign with manadatory details
		//homepage 
		HomePage hp=new HomePage(driver);
		hp.getCREATECAMPAIGNWE().click(); 
		
		//CreateCampaignPage
		CreateCampaignPage ccp=new CreateCampaignPage(driver);
		String cp = CAMPAIGNNAME + jlib.RandomAlphabet();
		ccp.getCAMPAIGNNAMEWE().sendKeys(cp); 
		WebElement ts = ccp.getTARGETSIZEWE(); 
		ts.clear(); 
		ts.sendKeys(TARGETSIZE); 
		ccp.getEXPECTEDCLOSEDATEWE().sendKeys(jlib.ExpectedDate());
		ccp.getCREATECAMPAIGNBUTTONWE().click();
		
		//Validati of create campaign
		WebElement toastmsg=hp.getTOASTMSGWE();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg = toastmsg.getText();
		Assert.assertEquals(msg, "Campaign " + cp + " Successfully Added");
		WebElement toastclose = hp.getTOASTCLOSE();
		wlib.waitForElementToBeInvisible(driver, toastclose);
		
		
		
		
		
	}
}
                                                                                                                                                                    