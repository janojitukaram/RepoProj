package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	static ExtentReports extent;

	public static ExtentReports extentReports()
	{
		String ExtentReportPath = System.getProperty("user.dir")+"\\Reports\\ExtentReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(ExtentReportPath);
		reporter.config().setReportName("Tutorials Ninja Automation tool");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Operating System", "Windows 10");
		extent.setSystemInfo("Tested By", "Tukaram Janoji");
		return extent;
		
	}

}
