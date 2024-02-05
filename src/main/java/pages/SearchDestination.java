package pages;


import commons.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import static pageObjects.GlobalElements.*;

public class SearchDestination extends Action {
    public String city;
    public String country;
//    Dates are in dd-mm/yyyy format
    public String dateStart;
    public String dateEnd;
    public int adults;
    public int children;
    public int infant;
    public int pet;
    public SearchDestination(String city, String country, String dateStart, String dateEnd,
                             int adults, int children, int infant, int pet, WebDriver driver) {
        super(driver);
        this.city = city;
        this.country = country;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.adults = adults;
        this.children = children;
        this.infant = infant;
        this.pet = pet;
    }

    public void submit_search_data() throws InterruptedException {
        inputText(SEARCH_DESTINATION , this.city);
//        build in a sleep since div gets loaded onto the screen, and selenium starts executing directly, whereas content is not loaded yet..
        Thread.sleep(3000);
        List<WebElement> searchResults = getElements(SEARCH_DESTINATION_RESULTS);
        String destination = this.city + ", " + this.country;
        for ( WebElement result : searchResults){
            String resultText= result.getText();
            if(resultText.equals(destination)){
                result.click();
                System.out.println("success!");
                break;
            }
            else{
                System.out.println("No Match!");
            }
        }
//        clickElement(CHECK_IN_DATE);
//        clickElement(CHECK_OUT_DATE);
    }
}
