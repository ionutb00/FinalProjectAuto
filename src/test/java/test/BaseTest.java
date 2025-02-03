package test;

import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import propertyUtility.PropertyUtility;

import static extentUtility.ExtentManager.*;

public class BaseTest {
 public WebDriver driver;
 public BasePage basePage;
 public String testName;
 public SearchPage searchPage;
 public LoginPage logPage;
 public ComparePage comparePage;
 public InteractionPage interactionPage;


    @BeforeSuite
    public void initiateReport(){
        initializeReport();
    }
    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        basePage = new BasePage(driver);
        logPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        comparePage=new ComparePage(driver);
        interactionPage= new InteractionPage(driver);




        driver.get("https://www.compari.ro");
        //Facem fereastra la dimensiunea maxima:
        driver.manage().window().maximize();

        testName = this.getClass().getSimpleName();
        createTest(testName);
    }
    @AfterMethod
   public void quitBrowser(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            String errorMessage = result.getThrowable().getMessage();
            logFailWithScreenshot(errorMessage, driver);
        }
        if (driver != null){
            driver.quit();
        }
        finishTest(testName);
    }
    @AfterSuite
     public void finalizeReport(){
    generateReport();
}
}
