package validations;

import commons.Action;
import commons.ConvertDate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookingDates extends Action {
    public BookingDates(WebDriver driver) {
        super(driver);
    }

    public void validateBookingDate(String dateCheckIn, String dateCheckOut) throws InterruptedException {
        String checkInDate = "//div[@data-testid=\"change-dates-checkIn\"]";
        String checkOutDate = "//div[@data-testid=\"change-dates-checkOut\"]";

        Thread.sleep(5000);
        String selectedCheckInDate = getElementText(checkInDate);
        String selectedCheckOutDate = getElementText(checkOutDate);

        assert selectedCheckInDate.equals(dateCheckIn): "Selected check in date does not match with shown check in date..";
        assert selectedCheckOutDate.equals(dateCheckOut): "Selected check out date does not match with shown check in date..";

    }

    public void validateBookingDateConfirmPay(String dateStart, String dateEnd){
        ConvertDate cd = new ConvertDate();

        String dayStart = cd.extractDayOutOfDate(dateStart);
        String dayEnd = cd.extractDayOutOfDate(dateEnd);
        String[] convertedMonths = cd.bookingDateConfirmPay(dateStart, dateEnd);

        String convertedMonthStart = convertedMonths[0];
        String convertedMonthEnd = convertedMonths[1];

        String elementDate = "//div[@class=\"s1q42845 atm_h3_logulu atm_vv_1jtmq4 dir dir-ltr\"]";

        String expectedDate;
        if(!convertedMonthStart.equals(convertedMonthEnd)) {
             expectedDate = String.format("%s %s - %s %s",convertedMonthStart , dayStart, convertedMonthEnd ,dayEnd );
        }
        else{
             expectedDate = String.format("%s %s - %s",convertedMonthStart , dayStart, dayEnd);
        }

        List<WebElement> elements =  getElements(elementDate);

        assert expectedDate.equals(elements.get(0).getText()) : "Dates do not match..";

    }


}
