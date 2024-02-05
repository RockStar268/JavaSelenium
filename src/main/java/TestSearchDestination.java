
import commons.TestSetup;
import org.testng.annotations.Test;
import pages.SearchDestination;


public class TestSearchDestination extends TestSetup {
    String outsideFrame = "//div[@role=\"dialog\"]/div[3]/div/div/button/span";
    @Test
    public void testOne() throws InterruptedException {
        SearchDestination sd = new SearchDestination("Bangkok", "Thailand" ,"04-12-2024", "12-12-2024",
                2, 0, 0, 0, driver);
//        ACT
        action.clickElement(outsideFrame);
        sd.submit_search_data();
    }
}
