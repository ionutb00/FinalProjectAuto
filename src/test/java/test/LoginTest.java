package test;
import org.testng.annotations.Test;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;


public class LoginTest extends BaseTest{



    @Test
    public void loghinTest(){
        logEvents(INFO_STEP,"We are complete the fields on login page");
        logPage.loginfill();
        logEvents(PASS_STEP, "expected result we should no complete the login because the data never exist");


    }



}
