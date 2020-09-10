package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageObjects.exReports;

public class Listeners extends base implements ITestListener {


	ExtentReports extent=exReports.getExtentReportObj();
	ExtentTest test;
	ThreadLocal<ExtentTest> tl = new ThreadLocal<ExtentTest>();//for parallel execution thread safe

	@Override
	public void onTestStart(ITestResult result) {
		 
		 test = extent.createTest(result.getMethod().getMethodName());
		 tl.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		tl.get().log(Status.PASS,"Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		tl.get().fail(result.getThrowable());
		
		
		WebDriver driver =null;
		
	String methodName = result.getMethod().getMethodName();
	try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch(Exception e)
	{
		
	}
	try {
		tl.get().addScreenCaptureFromPath(getScreenShotPath(methodName,driver), result.getMethod().getMethodName());
		getScreenShotPath(methodName,driver);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	

}
