
import commons.TestSetup;
import org.testng.annotations.Test;
import pages.SearchDestination;


public class TestSearchDestination extends TestSetup {
    String outsideFrame = "//div[@role=\"dialog\"]/div[3]/div/div/button/span";
    @Test
    public void testOne() throws InterruptedException {
        SearchDestination sd = new SearchDestination("Bangkok", "Thailand" ,"02/24/2024", "03/13/2024",
                2, 5, 2, 5, driver);
//        ACT
        action.clickElement(outsideFrame);
        sd.submit_search_data();


    }
}
