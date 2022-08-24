package listners;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.github.dockerjava.api.model.Driver;

import TestMethods.BaseCodeFile;
import Utility.TakeScreenshots;

public class ListNerClass extends BaseCodeFile implements ITestListener{
	ExtentReports reportx=ExtentReport.extentreportgenerator();
	ExtentTest  test;
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getName());
		test.fail(result.getThrowable());//It will give you exception information
		System.out.println("Test case :"+result.getMethod().getMethodName()+" has been  failed");
		TakeScreenshots.screenshotcapture(driver, result.getName()+".png");	
		try {
				test.addScreenCaptureFromPath(TakeScreenshots.captureScreenShotWithPath(driver, result.getName()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("screenshot added sucessfully in extent report");
			}
			
		}
	@Override
	public void onTestStart(ITestResult result) {
		
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test=reportx.createTest(result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, "test case is pass");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test is skipped");
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
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
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		reportx.flush();
	}

}
