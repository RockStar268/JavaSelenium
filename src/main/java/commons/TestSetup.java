package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static data.GlobalVariables.BASEURL;

public class TestSetup {
    protected WebDriver driver;
    protected Action action;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        action = new Action(driver);
        driver.get(BASEURL);
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

