package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Action {
    private WebDriver driver;
    public Action(WebDriver driver){
        this.driver = driver;
    }
    public void clickElement(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public void inputText(String xpath, String text){
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public List<WebElement> getElements(String xpath){
        return driver.findElements(By.xpath(xpath));

    }
}
