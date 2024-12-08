package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountsPage;
import testbase.baseClass;

public class LoginTest extends baseClass{
@Test(groups={"Sanity","Master"})
public void verifyLogin() {
	logger.info("***** Starting TC002_LoginTest  ****");
	boolean b;
	try {
		HomePage hp=new HomePage(driver);
		hp.clickOnAccount();
		hp.clickOnLogin();
		LoginPage l=new LoginPage(driver);
		l.setStringemail(p.getProperty("Email"));
		l.setStringpwd(p.getProperty("Passsword"));
		l.clickonsubmitbtn();
		MyAccountsPage ml=new MyAccountsPage(driver);
		b = ml.validateMessage();
		Assert.assertEquals(b,true,"Asset fails");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		Assert.fail();
	}

	
}
}
