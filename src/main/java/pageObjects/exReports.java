package pageObjects;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class exReports {
	
	static ExtentReports extent;
	public static ExtentReports getExtentReportObj()
	{
	
	String path = System.getProperty("user.dir")+"//Ereports//index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("FirstTest");
	reporter.config().setDocumentTitle("Automation");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("QA","Rupesh");
	return extent;
	

}
}
