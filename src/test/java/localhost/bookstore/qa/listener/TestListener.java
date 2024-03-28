package localhost.bookstore.qa.listener;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Attachment;
import localhost.bookstore.qa.baseclass.BaseClass;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener extends BaseClass implements ITestListener {

    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onFinish(ITestContext context) {
        //extentReports.flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] captureScreenshot(String methodName) {
        TakesScreenshot scrShot = (TakesScreenshot) driver;
        return scrShot.getScreenshotAs(OutputType.BYTES);
    }

}

