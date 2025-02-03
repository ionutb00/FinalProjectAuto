package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ExtentManager.logFailWithScreenshot;
import static extentUtility.ReportEventType.*;

public class LoginPage extends BasePage{
    @FindBy (id = "header-button-user")
    private WebElement loginButton;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement fillEmailAdress;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement fillPasswordField;
    @FindBy(id = "login-submit")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='col-lg-12 col-xs-12 error-message']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void loginfill(){
        basicHelpers.clickElement(loginButton);
        logEvents(INFO_STEP,"click on login icon");
        basicHelpers.fillElement(fillEmailAdress,"andreijoacabine@gmail.com");
        logEvents(INFO_STEP,"fill the email address field");
        basicHelpers.fillElement(fillPasswordField,"123456789");
        logEvents(INFO_STEP,"fill the password field");
        basicHelpers.clickElement(submitButton);
        logEvents(INFO_STEP,"click on submit button");
        logEvents(INFO_STEP,"A message with error must appear because the account never exist");
        basicHelpers.waitForElement(errorMessage);
        System.out.println("Un mesaj de eroare va fi afista " + errorMessage.getText());
        logFailWithScreenshot("Picture with the error",driver);

    }

}
