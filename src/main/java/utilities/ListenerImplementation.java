package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;

/***
 * Listeners Implementation with extent Reports for test PASS and FAIL
 */
public class ListenerImplementation implements ITestListener {
	ExtentReports extent = ExtentManager.getReport();

	public static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());

		test.assignAuthor("Satyam Sahu");
		test.assignCategory("Automation");
		test.info("Test Started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String methodName = result.getName();

		Reporter.log(methodName + " has been passed", true);

		test.pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		String methodName = result.getName();

		Object currentClass = result.getInstance();
		WebDriver driver = ((BaseClass) currentClass).getDriver();

		if (driver != null) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);

			String path = "./screenshots/" + methodName + "_" + timeStamp + ".png";

			File des = new File(path);

			try {
				FileHandler.copy(src, des);

				// ⭐ EXTENT REPORT ATTACHMENT
				test.info("Test failed Capturing Screenshot");
				test.addScreenCaptureFromPath(path);
				test.fail("Test Failed");

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String methodName = result.getName();

		Reporter.log(methodName + " has been skipped", true);

		test.skip("Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		extent = ExtentManager.getReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
