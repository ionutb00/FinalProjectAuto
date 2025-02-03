package test;
import org.testng.annotations.Test;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;

public class CompareTest extends BaseTest {



    @Test
    public void compareTest(){
        comparePage.compareFirstObjec();
        logEvents(INFO_STEP,"All the date are corectly added and the page works");
        comparePage.compareSecondObject();
        logEvents(INFO_STEP,"The second object also added in comparison");
        comparePage.modalPage();
        logEvents(PASS_STEP,"All the action works and the comparison page are showed ");

    }
}
