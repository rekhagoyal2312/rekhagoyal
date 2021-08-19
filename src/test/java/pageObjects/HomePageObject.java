package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	
	public WebDriver driver;
	
	public HomePageObject(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy (xpath="//span[normalize-space()='My Account']")
	WebElement lnkAccounts;
	
	@FindBy (xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy (xpath="//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	
	//Actions of page
	
	public void clickMyAccount() 
	{
		lnkAccounts.click();
	}
	
	public void clickRegister() 
	{	
		lnkRegister.click();
		
	}
	
	public void clickLogin() 
	{
		lnkLogin.click();
	}
	
	

}
