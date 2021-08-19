package testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePageObject;
import pageObjects.RegistrationPageObject;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {

	@Test(groups= {"master","sanity"})
	public void accountReg() throws IOException 
		{	
			try
			{
			
				driver.get(rb.getString("appUrl"));
				logger.info("Home Page Displayed ");
				driver.manage().window().maximize();
				HomePageObject hp = new HomePageObject(driver);
				hp.clickMyAccount();
				logger.info("Clicked on My Account ");
				hp.clickRegister();
				logger.info("Clicked on Register ");
			
				RegistrationPageObject rg = new RegistrationPageObject(driver);
				rg.setFName("abc");
				logger.info("Provided First Name ");
				rg.setlName("oyl");
				rg.setEmail(randomstring()+"@gmail.com");
				rg.setTelephone("976781233");
				rg.setPassword("abc1234");
				rg.setConfirmPassword("abc1234");
				rg.setPrivacyPolicy();
				rg.clickContinue();
				
				String confmsg=rg.getConfrimation();
				if (confmsg.equals("Your Account Has Been Created!"))
					{
						Assert.assertTrue(true);
					}else
					{
						Assert.assertTrue(false);
						capturescreenshot (driver,"TC_001_AccountRegistration");
					}
				}catch(Exception e)
				{
					logger.fatal("Account Registration Failed ");
					capturescreenshot (driver,"TC_001_AccountRegistration");
					Assert.fail();
					
				}
			logger.info(" Finished TC_001_AccountRegistration ");
		}
	
}
