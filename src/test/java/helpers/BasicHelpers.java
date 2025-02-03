package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasicHelpers {
    WebDriver driver;
    JavascriptExecutor js;
    public BasicHelpers(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }
    public void scrollDown() {
        js.executeScript("window.scrollBy(0,250)");
    }
    public void clickElement(WebElement element) {
        element.click();
    }
    public void fillElement(WebElement element, String text){
        element.sendKeys(text);
    }
    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void objectFind(){
        WebElement searchObject=driver.findElement(By.xpath("//button[@class='c-search__button']"));
        searchObject.click();
    }
    public void interactrWithProducts(){
        WebElement comparatiButton=driver.findElement(By.xpath("//a[@title='HP Victus 16-e1019nq 7H693EA Laptop']"));
        comparatiButton.click();
    }
    public void modalPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary pull-right']")));
        WebElement compare = modal.findElement(By.xpath("//a[@class='btn btn-primary pull-right']"));
        compare.click();

    }
    public void newTabPage(int index){
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(index));
    }





}
