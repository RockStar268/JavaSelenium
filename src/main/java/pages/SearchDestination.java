package pages;


import commons.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.GlobalElements;

import java.util.List;

import static pageObjects.GlobalElements.*;

public class SearchDestination extends Action {
    public String city;
    public String country;
 //    Dates are in mm/dd/yyyy format
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

    public void submitSearchData() throws InterruptedException {

        String addAdults = "//button[@data-testid=\"stepper-adults-increase-button\"]";
        String totalAmountAdults = "//span[@data-testid=\"stepper-adults-a11y-value-label\"]";
        String addChildren = "//button[@data-testid=\"stepper-children-increase-button\"]";
        String totalAmountChildren= "//span[@data-testid=\"stepper-children-a11y-value-label\"]";
        String addInfant = "//button[@data-testid=\"stepper-infants-increase-button\"]";
        String totalAmountInfant = "//span[@data-testid=\"stepper-infants-a11y-value-label\"]";
        String addPets = "//button[@data-testid=\"stepper-pets-increase-button\"]";
        String totalAmountPets = "//span[@data-testid=\"stepper-pets-a11y-value-label\"]";
        String searchButton = "//button[@data-testid=\"structured-search-input-search-button\"]";
        String searchResultPage = "//span[@class=\"tyi4kqb atm_c8_fkimz8 atm_g3_11yl58k atm_fr_4ym3tx atm_cs_qo5vgd dir dir-ltr\"]";

        inputText(SEARCH_DESTINATION , this.city);
        // build in a sleep since div gets loaded onto the screen, and selenium starts executing directly, whereas content is not loaded yet..
        Thread.sleep(3000);

        // Get search results and if match, click on it
        List<WebElement> searchResults = getElements(SEARCH_DESTINATION_RESULTS);
        String destination = this.city + ", " + this.country;
        for ( WebElement result : searchResults){
            String resultText= result.getText();
            if(resultText.equals(destination)){
                result.click();
                System.out.println("Destination is selected successfully!");
                break;
            }
            else{
                System.out.println("No match in your choosen destination..");
            }
        }

        // Select check in and out dates
        String CHECK_IN_DATE = GlobalElements.CHECK_IN_DATE + dateStart + "\"]";
        String CHECK_OUT_DATE = GlobalElements.CHECK_OUT_DATE + dateEnd + "\"]";
        clickElement(CHECK_IN_DATE);
        clickElement(CHECK_OUT_DATE);
        System.out.println("Your travel days are selected.");

        // Select amount of guest
        clickElement(GUESTS);


        if (this.adults > 0){
         for(int i = 0; i<this.adults; i++){
             clickElement(addAdults);
            }
            String getAmountAdults = getElementText(totalAmountAdults);
            String totalAdults = String.valueOf(this.adults) + " Adults";
            System.out.println("You have selected: " + totalAdults);
            assert getAmountAdults.equals(totalAdults) : "Adult value does not match!";
        }
        else{
            String getAmountAdults = getElementText(totalAmountAdults);
            assert getAmountAdults.equals("0 Adults");
        }

        if (this.children > 0){
            for(int i = 0; i<this.children; i++){
                clickElement(addChildren);
            }
            String getAmountChildren= getElementText(totalAmountChildren);
            String totalChildren = String.valueOf(this.children) + " Children";
            System.out.println("You have selected: " + totalChildren);
            assert getAmountChildren.equals(totalChildren) : "Children value does not match!";
        }
        else{
            String getAmountChildren = getElementText(totalAmountChildren);
            assert getAmountChildren.equals("0 Children");
        }

        if (this.infant > 0){
            for(int i = 0; i<this.infant; i++){
                clickElement(addInfant);
            }
            String getAmountInfant = getElementText(totalAmountInfant);
            String totalInfant = String.valueOf(this.infant) + " Infants";
            System.out.println("You have selected: " + totalInfant);
            assert getAmountInfant.equals(totalInfant) : "Infant value does not match!";
        }
        else{
            String getAmountInfant = getElementText(totalAmountInfant);
            assert getAmountInfant.equals("0 Infants");
        }

        if (this.pet > 0){
            for(int i = 0; i<this.pet; i++){
                clickElement(addPets);
            }
            String getAmountPets = getElementText(totalAmountPets);
            String totalPets = String.valueOf(this.pet) + " Pets";
            System.out.println("You have selected: " + totalPets);
            assert getAmountPets.equals(totalPets) : "Pets value does not match!";
        }
        else{
            String getAmountPets = getElementText(totalAmountPets);
            assert getAmountPets.equals("0 Pets");
        }

        clickElement(searchButton);
        assert elementIsDisplayed(searchResultPage);
    }

    public void selectStay(){
        String allStays = "//div[@itemprop=\"itemListElement\"]";

        List<WebElement> searchResultStay = getElements(allStays);

        if (!searchResultStay.isEmpty()) {
            // Click on the first found element
            searchResultStay.get(0).click();
            System.out.println("First available stay is selected");
        }
        else {
            System.out.println("No search result unfortunately..");
        }
    }

    public void reserveStay(){
        String reserveButton = "//button[@data-testid=\"homes-pdp-cta-btn\"]";

        List<WebElement> button = getElements(reserveButton); // this method is not stable.. sometimes 2 buttons appear with the same name and class and sometimes not.
        clickElement(String.valueOf(button.get(1)));          // due to bad practices on the airbnb site.
    }
    public void selectPaymentType(String paymentType){
        String payInFull = "//input[@id=\"payment-plan-selection-row-0\"]";
        String klarna = "//input[@id=\"payment-plan-selection-row-1\"]";

        switch(paymentType.toLowerCase()){
            case "pay in full":
                clickElement(payInFull);
            break;
            case "klarna":
                clickElement(klarna);
            break;
        }
    }
}
