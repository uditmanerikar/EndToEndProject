package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage (WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@name=\"email\"]")
	WebElement email;
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement passwoprd;
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement continuebtn;


	
	public void setStringemail(String em) {
		email.sendKeys(em);
			}
	
	public void setStringpwd(String pwd) {
		passwoprd.sendKeys(pwd);
					}	
	public void clickonsubmitbtn() {
		continuebtn.click();
	}

	}
	
			



