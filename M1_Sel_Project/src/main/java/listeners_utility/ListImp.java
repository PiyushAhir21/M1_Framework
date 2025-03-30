package listeners_utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base_utility.BaseClass;

public class ListImp implements ITestListener, ISuiteListener {

	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("DB connectivity, Report config");
		String date = new Date().toString().replace(" ", "").replace(":", "");
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"C:\\Users\\User\\git\\M1_framework\\M1_Sel_Project\\target\\report" + date + ".html");
		spark.config().setDocumentTitle("Vtiger-crm-framework");
		spark.config().setReportName("Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Windows", "10");
		report.setSystemInfo("Microsoft", "365");
		report.setSystemInfo("Unit testing tool", "TestNG");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("DB connectivity close, Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Advance reporting ke liye");
		test = report.createTest("advance");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String method = result.getMethod().getMethodName();
//		System.out.println(method + " got passed successfully !!");
//		Reporter.log(method + " got passed successfully !!", true);
		test.log(Status.PASS, "Test script running successfully!!!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String method = result.getMethod().getMethodName();
//		System.out.println(method + " got passed successfully !!");
//		Reporter.log(method + " got failed !!!", true);
		test.log(Status.FAIL, "Test script got failed");

//		Code for taking screenshot
		BaseClass b = new BaseClass();
		TakesScreenshot tks = (TakesScreenshot) BaseClass.sdriver;
		File filepath = tks.getScreenshotAs(OutputType.FILE);
//		test.addScreenCaptureFromBase64String(filepath, "ErrorFile");
		test.log(Status.FAIL, method + " is failed !!!");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String method = result.getMethod().getMethodName();
//		System.out.println(method + " got passed successfully !!");
//		Reporter.log(method + " got skipped !!!", true);
		test.log(Status.SKIP, method + " got skipped !!!");
	}

}
