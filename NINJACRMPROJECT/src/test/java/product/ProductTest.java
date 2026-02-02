package product;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import config.baseclass;
import pom.AddProductPage;
import pom.HomePage;
@Listeners(listener.ListenerImplementation.class)
public class ProductTest extends baseclass {
	@Test
	public void createProductTest() throws EncryptedDocumentException, IOException {
		
		String PRODUCT = elib.toReadDataFromExcelFile("Product", 1, 0);
		String CATEGORY = elib.toReadDataFromExcelFile("Product", 1, 1);
		String QUANTITY = elib.toReadDataFromExcelFile("Product", 1, 2);
		String PRICE = elib.toReadDataFromExcelFile("Product", 1, 3);
		String VENDOR = elib.toReadDataFromExcelFile("Product", 1, 4);
		
			HomePage hp=new HomePage(driver);
		//Create product with mandatory details
		AddProductPage adp=new AddProductPage(driver);
		hp.getPRODUCTWE().click();
		adp.getADDPRODUCTWE().click();
		WebElement ts = adp.getQUANTITYWE();
		ts.clear();
		ts.sendKeys(QUANTITY);
		String pr = PRODUCT+jlib.randomCount();
		adp.getPRODUCTNAMEWE().sendKeys(pr);
		WebElement price = adp.getPRICEWE();
		price.clear();
		price.sendKeys(PRICE);
		
		WebElement categoryDropdown = adp.getPRODUCTCATEGORYWE();
		wlib.selectByVisibleText(CATEGORY,categoryDropdown);
		WebElement vendorDropdown = adp.getVENDORWE();
		wlib.selectByVisibleText(VENDOR,vendorDropdown);
		adp.getADDPRODUCTBUTTONWE().click();
		
		//Validation of create Product
				WebElement toastmsg=hp.getTOASTMSGWE();
				wlib.waitForElementToBeVisible(driver,toastmsg);
				String msg = toastmsg.getText();
				System.out.println(msg);
				Assert.assertEquals(msg,"Product "+pr+" Successfully Added");
				WebElement toastclose = hp.getTOASTCLOSE();
				wlib.waitForElementToBeInvisible(driver, toastclose);
	}
}
