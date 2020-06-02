package Framework.firstFramework;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.WebDriver;
import Resources.BaseClass;
import Resources.ExtentReporterNG;

public class Listeners extends BaseClass implements ITestListener {
	ExtentTest test; // to make it work without ambiguity while parallel execution of tests change the
						// type to ThreadLocal
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	ExtentReports report = ExtentReporterNG.getReporter();

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		// test = report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// test.log(Status.PASS, "Test passed");
		extentTest.get().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {

		// test.fail(result.getThrowable()); // to log failure using extentReport
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String failedMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {

		}
		try 
		{
			//To place screenshot in the extent report rather than having it separately in reports folder
			extentTest.get().addScreenCaptureFromPath(getScreenshot(failedMethodName, driver), failedMethodName);
		} 
		catch (IOException e) {

		}
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

}
