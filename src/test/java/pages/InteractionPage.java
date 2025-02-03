package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;


public class InteractionPage extends BasePage{
    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchBar;
    @FindBy (xpath = "//button[@class='c-search__button']")
    private WebElement objectFind;
    @FindBy (xpath = "//a[@title='Imperial All Season Driver 195/65 R15 91H']")
    private WebElement selectObject;
    @FindBy (xpath = "//span[@content='229']")
    private WebElement goToOtherSite;
    @FindBy (xpath = "//div[@id='cookiescript_accept']")
    private WebElement acceptCookies;
    @FindBy (xpath = "//div[@class='prodname_price_wrapper']/h5")
    private WebElement priceText;
    @FindBy (xpath = "//span[@content='229']")
    private WebElement comparePriceText;
    public InteractionPage(WebDriver driver) {
        super(driver);

    }

    public void selectProduct(){
        basicHelpers.clickElement(searchBar);
        logEvents(INFO_STEP,"Found the search bar in HomePage");
        basicHelpers.fillElement(searchBar,"anvelope all season");
        logEvents(INFO_STEP,"Introduce the object that you want to find in search bar");
        basicHelpers.clickElement(objectFind);
        logEvents(PASS_STEP,"Successfully redirect at the result page");
        basicHelpers.clickElement(selectObject);
        logEvents(INFO_STEP, "Select the object what you want to see");
        System.out.println("Pretul de pe site este " + comparePriceText.getText());
        logEvents(INFO_STEP, "Get in console the price of the object in the main site");
        basicHelpers.scrollDown();
        basicHelpers.clickElement(goToOtherSite);
        logEvents(PASS_STEP,"we select the associated site button to see the price correspondences");


    }
    public void secondPage(){
       basicHelpers.newTabPage(1);
       logEvents(PASS_STEP,"Successfully redirect in the associated site page");
       basicHelpers.clickElement(acceptCookies);
       logEvents(PASS_STEP,"Successfully accept the all cookies page");
        System.out.println(" Pretul pe site-ul comerciantului este " +priceText.getText() + " RON " );
        logEvents(INFO_STEP,"Get in the console the actual price of the associated site");

    }

}

