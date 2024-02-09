package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
      WebElement parentElement = waitForElement(xpath);
        return parentElement.findElements(By.xpath(xpath));
    }

    public String getElementText(String xpath){
        WebElement element = waitForElement(xpath);
        return element.getText();
    }

    public boolean elementIsDisplayed(String xpath){
        try{
            WebElement element = waitForElement(xpath);
            element.findElement(By.xpath(xpath)).isDisplayed();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void moveToAndClickElement(String xpath){
        WebElement element = waitForElement(xpath);
        Actions a = new Actions(driver);
        a.moveToElement(element).click().build().perform();
    }

    private WebElement waitForElement(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}
