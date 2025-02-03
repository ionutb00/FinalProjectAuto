package pages;

import helpers.BasicHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import propertyUtility.PropertyUtility;

public class BasePage {

    public WebDriver driver;
    public BasicHelpers basicHelpers;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        basicHelpers= new BasicHelpers(driver);
        PageFactory.initElements(driver,this);
    }
    public void openBrowser(){
        driver=new ChromeDriver();
        driver.get("https://www.compari.ro/");
        driver.manage().window().maximize();
    }

}
