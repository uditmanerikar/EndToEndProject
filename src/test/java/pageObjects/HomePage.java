package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement lnMyAccount;
	@FindBy(xpath="//a[text()='Register']")
	WebElement Register;
	@FindBy(xpath="//ul[@class=\"dropdown-menu dropdown-menu-right\"]//child::a[@href=\"https://tutorialsninja.com/demo/index.php?route=account/login\" and text()='Login']")
	WebElement Login;

	public void clickOnAccount(){
		lnMyAccount.click();
	}
	public void clickOnRegister(){
		Register.click();
	}
	public void clickOnLogin(){
		Login.click();
	}
	
	
	
}
