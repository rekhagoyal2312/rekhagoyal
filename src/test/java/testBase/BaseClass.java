package testBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Logger logger; //For Logging 
	public ResourceBundle rb;// to read config .properties file
	
	@BeforeClass(groups= {"master","sanity","regression"})
	@Parameters({"browser"})
	public void setup(String br)
		{	
		//Load config properties file
		rb= ResourceBundle.getBundle("config");
		//logging
		logger=LogManager.getLogger(this.getClass());
			if(br.equals("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}else if (br.equals("edge"))
				{
				WebDriverManager.edgedriver().setup();
				driver= new EdgeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				}else if(br.equals("firefox"))
				{
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				}
		}

	
@AfterClass(groups= {"master","sanity","regression"})
	
public void teardown() throws InterruptedException
	{	
		driver.quit();
	    
		
	}
	
	
	public String randomstring()
	{	String genrateString = RandomStringUtils.randomAlphabetic(7);
		return genrateString;
	}
	public int randomint()
	{	String genrateInt = RandomStringUtils.randomNumeric(5);
		return (Integer.parseInt(genrateInt));
	}
	
	public void capturescreenshot (WebDriver driver,String testname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File (System.getProperty("user.dir")+"\\screenshots\\"+testname+".png");
		FileUtils.copyFile(source, target);
		
	}

}
