
import commons.TestSetup;
import org.testng.annotations.Test;
import pages.SearchDestination;

import static pageObjects.GlobalElements.SEARCH_DESTINATION;

public class test1 extends TestSetup {
    String outsideFrame = "//div[@data-testid=\"modal-container\"]";
    @Test
    public void testOne() {
        SearchDestination sd = new SearchDestination("Bangkok", "Thailand" ,"04-12-2024", "12-12-2024",
                2, 0, 0, 0, driver);
//        ACT
        action.clickElement(outsideFrame);
        sd.submit_search_data();
    }
}
