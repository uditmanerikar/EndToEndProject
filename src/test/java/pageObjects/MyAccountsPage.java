package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountsPage extends BasePage{

	public MyAccountsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement ValidateMyAccount;
	@FindBy(xpath="//a[@class=\"list-group-item\" and text()='Logout']")
	WebElement Logout;
	
	
	
	
public boolean validateMessage() {
	try {
		return ValidateMyAccount.isDisplayed();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		return false;
	}
}
public void clickLogout() {
	Logout.click();
}
}