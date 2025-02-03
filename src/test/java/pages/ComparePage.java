package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;


public class ComparePage extends BasePage{
    @FindBy (xpath = "//input[@type='search']")
    private WebElement searchBar;
    @FindBy (xpath = "//button[@class='c-search__button']")
    private WebElement searchOBjectClick;
    @FindBy (xpath = "//a[@title='HP Victus 16-e1019nq 7H693EA Laptop']")
    private WebElement compareButton;
    @FindBy (xpath = "//a[@class='add-to-compare']")
    private WebElement selectToCompare;
    @FindBy(xpath = "//button[@class='c-search__button']")
    private WebElement searchSecondObject;
    @FindBy(xpath = "//a[@title='ASUS TUF Gaming FA506NFR-HN090 Laptop - Comparatii de preturi']")
    private WebElement selectSecondObject;
    @FindBy (xpath = "//a[@id='header-button-comparison']")
    private WebElement compareButton2;
    @FindBy (xpath = "//a[@class='btn btn-primary pull-right']")
    private WebElement compareModalPageButton;
    public ComparePage(WebDriver driver) {
        super(driver);
    }
    public void compareFirstObjec(){
        basicHelpers.clickElement(searchBar);
        logEvents(INFO_STEP,"In Home page we are select the search Bar");
        basicHelpers.fillElement(searchBar,"laptop hp");
        logEvents(INFO_STEP,"we type in the text we want");
        basicHelpers.clickElement(searchOBjectClick);
        logEvents(PASS_STEP,"Successfully redirect to results page");
        basicHelpers.clickElement(compareButton);
        logEvents(INFO_STEP,"Click on the compare buton in front of the object we want to compare");
        basicHelpers.clickElement(selectToCompare);
        logEvents(PASS_STEP,"Successfully select to compare the object");

    }
    public void compareSecondObject(){
        basicHelpers.clickElement(searchBar);
        logEvents(INFO_STEP,"New search we must make ");
        basicHelpers.fillElement(searchBar,"laptop asus");
        logEvents(INFO_STEP,"Fill the search bar with text you need ");
        basicHelpers.clickElement(searchSecondObject);
        logEvents(INFO_STEP,"click on search button");
        basicHelpers.clickElement(selectSecondObject);
        logEvents(PASS_STEP,"Successfully redirect on another result page");
        basicHelpers.clickElement(selectToCompare);
        logEvents(INFO_STEP,"Select the second object to compare");
        basicHelpers.clickElement(compareButton2);
        logEvents(PASS_STEP,"Successfully add the second object to compare");

    }
    public void modalPage(){
        basicHelpers.modalPage();
        logEvents(INFO_STEP,"We are redirect to a modal Page to select the button compareButton");
        basicHelpers.clickElement(compareModalPageButton);
        logEvents(PASS_STEP,"Successfully redirect to comparison page");
    }
}
