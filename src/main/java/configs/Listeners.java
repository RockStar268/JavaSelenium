package configs;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class Listeners extends Base implements ITestListener {
    WebDriver driver;

    @Override
    public void onTestStart(ITestResult result){

        System.out.println("Test Execution is starting for: " + result.getName());
    }
    @Override
    public void onFinish(ITestContext context){
        System.out.println("Test Execution ended for: " + context.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test Execution successful for: " + result.getName());
    }
//    @Override   // not working :(
//    public void onTestFailure(ITestResult result){
//
//        try {
//            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//        } catch (IllegalAccessException | NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Test Execution failed for: " + result.getName());
//        takeScreenshot(result.getMethod().getMethodName(), driver);
//    }
    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("Test Execution skipped for: " + result.getName());
    }

}

