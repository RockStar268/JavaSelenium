package pages;

import commons.Action;
import org.openqa.selenium.WebDriver;

public class TranslationToggle extends Action {
    public String languageRegionButton = "//div[@class=\"lx138ae atm_h_1h6ojuz atm_9s_1txwivl atm_e2_1osqo2v atm_mk_h2mmj6 atm_wq_kb7nvz dir dir-ltr\"]/../../button";

    public TranslationToggle(WebDriver driver) {
        super(driver);
    }

    public void turnOffTranslation(){
        String translationToggleOff = "//button[@class=\"canm9xs atm_5j_1vi7ecw atm_66_nqa18y atm_6h_t94yts atm_9j_tlke0l atm_e2_1vi7ecw atm_mk_h2mmj6 atm_jb_fyhuej atm_vy_fyhuej atm_kd_glywfm atm_9j_13gfvf7_1o5j5ji atm_3f_glywfm_jo46a5 atm_l8_idpfg4_jo46a5 atm_gi_idpfg4_jo46a5 atm_3f_glywfm_1icshfk atm_kd_glywfm_19774hq atm_uc_x37zl0_1w3cfyq atm_70_sdqqc6_1w3cfyq atm_uc_glywfm_1w3cfyq_p88qr9 atm_uc_x37zl0_18zk5v0 atm_70_sdqqc6_18zk5v0 atm_uc_glywfm_18zk5v0_p88qr9 c1i6tylb atm_2d_1qj3mzt atm_4b_1qj3mzt atm_2d_70a7u9_1o5j5ji atm_4b_70a7u9_1o5j5ji atm_4b_70a7u9_itk5vk dir dir-ltr\"]";

        clickElement(languageRegionButton);
        clickElement(translationToggleOff);
    }
}
