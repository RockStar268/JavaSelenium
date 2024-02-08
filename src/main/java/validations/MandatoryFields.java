package validations;

import commons.Action;
import enums.ErrorMessages;
import org.openqa.selenium.WebDriver;

public class MandatoryFields extends Action {

    public MandatoryFields(WebDriver driver) {
        super(driver);
    }

    public void phoneNumberField(){
        String errorMessageBanner = "//div[@class=\"_lnlh4ma\"]/span";

        assert getElementText(errorMessageBanner).equals(ErrorMessages.PHONE_NUMBER_FIELD.getMessage());

    }
}
