package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testbase.baseClass;

public class AccountRegistrationTest  extends baseClass{


@Test(groups={"Regression","Master"})
void verify_Account_registration() throws InterruptedException {
	logger.info("***** Starting TC001_AccountRegistrationTest  ****");
	logger.debug("This is a debug log message");
	try 
	{
	HomePage hp=new HomePage(driver);
	hp.clickOnAccount();
	logger.info("My Account Link");
	hp.clickOnRegister();
	logger.info("My registration Link");
	AccountRegistrationPage ap= new AccountRegistrationPage(driver);
	Thread.sleep(2000);
	logger.info("Providing Customer Details");
	ap.setStringfname(randowmstring().toUpperCase());
	ap.setStringlname(randowmstring().toUpperCase());
	ap.setStringemail(randowmstring()+"@gmail.com");
	ap.setStringtelephone(randowmNumber());
	String password=randomalphanumeric();
	ap.setStringpwd(password);
	ap.setStringname(password);
	ap.setStringpol();
	ap.clickcontinue();
	Thread.sleep(8000);
	//logger.info("validating expected message ");
	String confirmationmessage=ap.validatemessage();
	if(confirmationmessage.equals("Congratulations! Your new account has been successfully created!"))
	{
		Assert.assertTrue(true);
	}
	else {
		logger.error("Test failed: ");
		Assert.fail("Test failed: ");
		Assert.assertTrue(false);
	}
	Thread.sleep(8000);
	}
	catch (Exception e)
	{
		
	} 
	finally 
	{
	logger.info("***** Finished TC001_AccountRegistrationTest *****");
	
	
	}}}
	


