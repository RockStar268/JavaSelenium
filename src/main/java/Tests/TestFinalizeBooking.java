package Tests;

import configs.TestSetup;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;
import pages.SearchDestination;
import pages.TranslationToggle;
import validations.BookingDates;
import validations.MandatoryFields;

import java.util.List;


public class TestFinalizeBooking extends TestSetup {
    String homePagePopUp = "//button[@class=\"l1ovpqvx atm_1y33qqm_1ggndnn_10saat9 atm_17zvjtw_zk357r_10saat9 atm_w3cb4q_il40rs_10saat9 atm_1cumors_fps5y7_10saat9 atm_52zhnh_1s82m0i_10saat9 atm_jiyzzr_1d07xhn_10saat9 c1b3fvnw atm_1s_glywfm atm_9s_1o8liyq atm_5j_1ssbidh atm_kd_idpfg4 atm_gi_16flvx1 atm_l8_1v6z61t atm_7l_1u9drld atm_9j_tlke0l atm_tl_1gw4zv3 atm_2d_1kuelp3 atm_3f_6q8byr atm_70_1n51njw atm_uc_1dtz4sb atm_kd_glywfm_1w3cfyq atm_uc_x37zl0_1w3cfyq atm_70_1snd6fg_1w3cfyq atm_3f_glywfm_e4a3ld atm_l8_idpfg4_e4a3ld atm_gi_idpfg4_e4a3ld atm_3f_glywfm_1r4qscq atm_kd_glywfm_6y7yyg atm_uc_glywfm_1w3cfyq_p88qr9 atm_kd_glywfm_18zk5v0 atm_uc_x37zl0_18zk5v0 atm_70_1snd6fg_18zk5v0 atm_3f_glywfm_6mgo84 atm_l8_idpfg4_6mgo84 atm_gi_idpfg4_6mgo84 atm_3f_glywfm_16p4kaz atm_kd_glywfm_17yx6rv atm_uc_glywfm_18zk5v0_p88qr9 atm_k4_1piyxwk_1o5j5ji atm_9j_13gfvf7_1o5j5ji atm_7l_jajhky_1o5j5ji atm_2d_1v67ije_csw3t1 atm_tr_ffmgpj_csw3t1 atm_2d_1v67ije_1nos8r_uv4tnr atm_uc_glywfm__p88qr9 dir dir-ltr\"]";
    String reserveButton = "//button[@data-testid=\"homes-pdp-cta-btn\"]";
    String submitButton = "//button[@data-veloute=\"submit-btn-cypress\"]";


    @Test
    public void turnOffTranslation() {
        TranslationToggle tt = new TranslationToggle(driver);

        if (action.elementIsDisplayed(homePagePopUp)) {
            action.moveToAndClickElement(homePagePopUp);  // not working.. need to click away manually
        }
        tt.turnOffTranslation();
    }

    @Test (dependsOnMethods = "turnOffTranslation")
    public void submitSearchData() throws InterruptedException {
        SearchDestination sd = new SearchDestination("Bangkok", "Thailand" ,"02/24/2024", "03/13/2024",
                2, 5, 2, 0, driver);
            sd.submitSearchData();
        }

    @Test (dependsOnMethods = "submitSearchData")
    public void selectStay() {
        SearchDestination sd = new SearchDestination("Bangkok", "Thailand" ,"02/24/2024", "03/13/2024",
                2, 5, 2, 0, driver);
        sd.selectStay();
        List<WebElement> button = action.getElements(reserveButton); // this method is not stable.. sometimes 2 buttons appear with the same name and class and sometimes not.
        action.clickElement(String.valueOf(button.get(1)));          // due to bad practices on the airbnb site.
    }

    @Test (dependsOnMethods = "selectStay")
    public void submitBookingWithoutFillingInMandatoryFields() {
        SearchDestination sd = new SearchDestination("Bangkok", "Thailand" ,"02/24/2024", "03/13/2024",
                2, 5, 2, 0, driver);

        BookingDates bk = new BookingDates(driver);
        // VALIDATE
        bk.validateBookingDateConfirmPay(sd.dateStart, sd.dateEnd);
        // ACT
        sd.selectPaymentType("Full");
        action.clickElement(submitButton);
    }

    @Test (dependsOnMethods = "submitBookingWithoutFillingInMandatoryFields")
    public void phoneNumberFieldMandatory(){
        MandatoryFields mf = new MandatoryFields(driver);
        // VALIDATE
        mf.phoneNumberField();

    }
}
