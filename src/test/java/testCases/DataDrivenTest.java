package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountsPage;
import testbase.baseClass;
import utilities.DataProviders;

public class DataDrivenTest  extends baseClass{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verifyLogin(String em,String pa,String exp) {
		logger.info("***** Starting TC03  Data Driven  ****");
		boolean b;
			try{
			HomePage hp=new HomePage(driver);
			hp.clickOnAccount();
			hp.clickOnLogin();
			LoginPage l=new LoginPage(driver);
			l.setStringemail(em);
			l.setStringpwd(pa);
			l.clickonsubmitbtn();
			MyAccountsPage ml=new MyAccountsPage(driver);
			b = ml.validateMessage();
			if(exp.equalsIgnoreCase("valid")) {
			if(b==true) {
				ml.clickLogout();
				Assert.assertTrue(true);
			}	
			else {
				Assert.assertTrue(false);
			}
			}
			else {
				if(exp.equalsIgnoreCase("Invalid")) {
					if(b==true) {
						ml.clickLogout();
						Assert.assertTrue(false);
					}
					else {
						Assert.assertTrue(true);
					}
				}
			}
			}
			catch(Exception e) {
				
				Assert.fail("An exception occurred: " + e.getMessage());}
			}
			
}
			
			
	
