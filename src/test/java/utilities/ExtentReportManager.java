package utilities;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	 String repName;
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp =  new SimpleDateFormat("YYYY.MM.hh.mm.ss").format(new Date()); // time stamp
		repName = "Test-Reports-"+timeStamp+".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName); // specify the location of the reports
	
		sparkReporter.config().setDocumentTitle("OpenCart Test Report"); // Report Title 
		sparkReporter.config().setReportName("OpenCart Funcational Testing"); // Report Name
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application","OpenCart");
		extent.setSystemInfo("Module", "Test");
		extent.setSystemInfo("Operating System",System.getProperty("os.name") );
		extent.setSystemInfo("UserName", System.getProperty("user.name") );
		extent.setSystemInfo("Envi", "QA");
		extent.setSystemInfo("Tester", "Rekha");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		try
		{
		String screenshotPath=System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png";
		test.addScreenCaptureFromPath(screenshotPath);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Skikpped");

	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	
	}

}
