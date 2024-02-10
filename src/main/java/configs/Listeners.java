package configs;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Listeners implements ITestListener {
    private WebDriver driver;

    public void onTestStart(ITestResult result){
        System.out.println("Test Execution is starting for: " + result.getName());
    }

    public void onFinish(ITestContext context){
        System.out.println("Test Execution ended for: " + context.getName());
    }

    public void onTestSuccess(ITestResult result){
        System.out.println("Test Execution successful for: " + result.getName());
    }

    public void onTestFailure(ITestResult result){
        System.out.println("Test Execution failed for: " + result.getName());
        takeScreenshot(result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result){
        System.out.println("Test Execution skipped for: " + result.getName());
    }

    private void takeScreenshot(String methodName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "screenshots/" + methodName + ".png";
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            System.out.println("Screenshot saved at: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

