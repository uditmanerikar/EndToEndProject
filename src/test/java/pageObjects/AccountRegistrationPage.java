package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	public AccountRegistrationPage (WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@name=\"firstname\"]")
	WebElement firstname;
	@FindBy(xpath="//input[@name=\"lastname\"]")
	WebElement lastname;
	@FindBy(xpath="//input[@name=\"email\"]")
	WebElement email;
	@FindBy(xpath="//input[@name=\"telephone\"]")
	WebElement telephone;
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement passwoprd;
	@FindBy(xpath="//input[@name=\"confirm\"]")
	WebElement confirmpassword;
	@FindBy(xpath="//input[@name=\"agree\"]")
	WebElement chkpolicy;
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement continuebtn;
	@FindBy(xpath="//p[text()='Congratulations! Your new account has been successfully created!']")
	WebElement validatemessage;

	//p[text()='Congratulations! Your new account has been successfully created!']
	public void setStringfname(String fname) {
	firstname.sendKeys(fname);
	}
	public void setStringlname(String lname) {
		lastname.sendKeys(lname);
		}
	public void setStringemail(String em) {
		email.sendKeys(em);
			}
	public void setStringtelephone(String tel) {
		telephone.sendKeys(tel);
				}
	public void setStringpwd(String pwd) {
		passwoprd.sendKeys(pwd);
					}	
	public void setStringname(String cpwd) {
		confirmpassword.sendKeys(cpwd);
	}
	
	public void setStringpol() {
		chkpolicy.click();
	
	}
	public void clickcontinue() {
		continuebtn.click();
	
	}
	
	public String validatemessage() {
			try {
			return(validatemessage.getText());
		}		
			catch(Exception e) {
				return(e.getMessage());
			}}}
			


