package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static data.GlobalVariables.BASEURL;

public class TestSetup {
    protected WebDriver driver;
    protected Action action;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        action = new Action(driver);
        driver.get(BASEURL);
        driver.manage().window().maximize();

    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

