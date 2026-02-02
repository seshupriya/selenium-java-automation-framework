package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignmentProductPage {
	
	@FindBy(name="add-to-cart-sauce-labs-backpack")
	WebElement productName;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement CartLink;
	
	@FindBy(name="checkout")
	WebElement CheckOutBtn;
	
	@FindBy(id="first-name")
	WebElement FirstName;
	
	@FindBy(id="last-name")
	WebElement LastName;
	
	@FindBy(id="postal-code")
	WebElement postalCode;
	
	@FindBy(id="continue")
	WebElement ContinueBtn;
	
	@FindBy(id="finish")
	WebElement FinishBtn;
	
	public  AssignmentProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getCartLink() {
		return CartLink;
	}

	public WebElement getCheckOutBtn() {
		return CheckOutBtn;
	}

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getPostalCode() {
		return postalCode;
	}

	public WebElement getContinueBtn() {
		return ContinueBtn;
	}

	public WebElement getFinishBtn() {
		return FinishBtn;
	}
	
}
