package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignmentLoginPage {
	
	@FindBy(id="user-name")
	private WebElement uN;
	
	@FindBy(id="password")
	private WebElement pWD;
	
	@FindBy(id="login-button")
	private WebElement loGin;
	
	public AssignmentLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getuN() {
		return uN;
	}

	public WebElement getpWD() {
		return pWD;
	}

	public WebElement getLoGin() {
		return loGin;
	}
	
	
}
