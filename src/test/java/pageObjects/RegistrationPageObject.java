package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPageObject {
	
	public WebDriver driver;
	
	public RegistrationPageObject(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//input[@id='input-firstname']")
	WebElement txtfName;
	
	@FindBy (xpath="//input[@id='input-lastname']")
	WebElement txtlName;
	
	@FindBy (xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy (xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy (xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy (xpath="//input[@id='input-confirm']")
	WebElement txtconfpassword;
	
	@FindBy(name="agree")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement txtmsgConfirmation;
	
	public void setFName(String fName)
	{
		txtfName.sendKeys(fName);
	}
	
	public void setlName(String lName)
	{
		txtlName.sendKeys(lName);
	}
	
	public void setEmail(String Email)
	{
		txtemail.sendKeys(Email);
	}
	
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cnfpwd)
	{
		txtconfpassword.sendKeys(cnfpwd);
	}
	
	public void setPrivacyPolicy()
	{
		chkdPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfrimation() 
	{
		try{
			return (txtmsgConfirmation.getText());
		}catch(Exception e)
		{
			return (e.getMessage());
		}
		
	}

}
