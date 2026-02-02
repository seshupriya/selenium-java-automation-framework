package listener;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.BaseClassFinder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import config.baseclass;

public class ListenerImplementation implements ITestListener ,ISuiteListener{
	public ExtentReports report;
	ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		Date d=new Date();
	 	String newdate = d.toString().replace(" ","_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvancedReport/Reports_"+newdate+".html");
		spark.config().setDocumentTitle("NinjaCRM");
		spark.config().setReportName("CRMREPORT");
		spark.config().setTheme(Theme.DARK);
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "window");
		report.setSystemInfo("windowVersion", "11");
		report.setSystemInfo("browser", "chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		 test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "execution got started");
		Reporter.log(result.getMethod().getMethodName()+"Execution started",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "execution completed successfully");
		Reporter.log(result.getMethod().getMethodName()+"Execution completed successfully",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testcase = result.getMethod().getMethodName();
		test.log(Status.FAIL, "execution failed");
		Reporter.log(result.getMethod().getMethodName()+"Execution failed",true);
		Date d=new Date();
	 	String newdate = d.toString().replace(" ","_").replace(":", "_");
   
		TakesScreenshot ts=(TakesScreenshot) baseclass.sdriver;
        String src = ts.getScreenshotAs(OutputType.BASE64);
        test.addScreenCaptureFromBase64String(src,testcase+newdate);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName()+"Execution got skipped",true);	
	}

}
