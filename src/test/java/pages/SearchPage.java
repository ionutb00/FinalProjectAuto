package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;


public class SearchPage extends BasePage{
    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchBar;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchFieldBar;
    @FindBy (xpath = "//button[@class='c-search__button']")
    private WebElement objectFind;
    @FindBy (xpath = "//a[@title='HP Victus 16-e1019nq 7H693EA Laptop']")
    private WebElement interactWithProduct ;
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public void searchBarClick() {
        basicHelpers.clickElement(searchBar);
        logEvents(INFO_STEP, "Start test in home page find the search bar");
    }
    public void searchField(){
        basicHelpers.fillElement(searchBar,"laptop hp");
        logEvents(INFO_STEP, "We write the name of object we want to find");
    }
    public void clickElement(){
        basicHelpers.clickElement(searchBar);
        logEvents(PASS_STEP,"Are redirect to another page with more results");

    }
    public void objectFind(){
        basicHelpers.objectFind();
        logEvents(INFO_STEP,"select the object from the list");
    }
    public void interactWithProduct(){
        basicHelpers.interactrWithProducts();
        logEvents(INFO_STEP,"click at the object and are redirect on a page with more detail about the product");

    }


}
