package test;

import org.testng.annotations.Test;

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;

public class InteractionTest extends BaseTest{

    @Test
    public void interactionTest(){
        interactionPage.selectProduct();
        logEvents(INFO_STEP,"WE SEARCH AN OBJECT IN SITE AND SEE IF THE PRICE ARE COMPATIBLE");
        interactionPage.secondPage();
        logEvents(PASS_STEP,"WE CONTROL THE PRICE FIELD AND SEE IF CORESPONDS WITH THE ORIGINAL SITE");
    }
}
