package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Action {
    private final WebDriver driver;

    public Action(WebDriver driver){

        this.driver = driver;
    }
    public void clickElement(String xpath) {
        try {
            WebElement element = waitForElement(xpath);
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void inputText(String xpath, String text) {
        try {
            WebElement element = waitForElement(xpath);
            element.sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<WebElement> getElements(String xpath){
//        WebElement parentElement = waitForElement(xpath);
        return driver.findElements(By.xpath(xpath));
    }
    private WebElement waitForElement(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}
