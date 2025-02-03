package test;
import org.testng.annotations.Test;


import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;


public class SearchTest extends BaseTest {


    @Test
 public void test(){

        searchPage.searchBarClick();
        searchPage.searchField();
        logEvents(INFO_STEP," verify if the search field is correctly found");
        searchPage.clickElement();
        searchPage.objectFind();
        logEvents(PASS_STEP, "are redirect at a new page with results");
        searchPage.interactWithProduct();
        logEvents(PASS_STEP,"the page with details are successfully loaded");


 }

}