package extentUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;

public class ExtentManager {
    private static String pathToProject = System.getProperty("user.dir") + "/target/extentReports/";
    private static ExtentReports extentReports;
    private static ConcurrentHashMap<String, ExtentTest> context = new ConcurrentHashMap<>();

    private static void createDirectory(){
        File directory = new File(pathToProject);
        if (!directory.exists()){
            directory.mkdirs();
        }
    }
    public static synchronized void initializeReport(){
        createDirectory();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(pathToProject + "ExtentReport.html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Test Report");
        htmlReporter.config().setReportName("Automated Test Results");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    public static synchronized void createTest(String testName){
        ExtentTest testReport = extentReports.createTest(testName + " - report");
        context.put(Thread.currentThread().getName(), testReport);
        logEvents(INFO_STEP, "--- START TEST --- " +testName);
    }

    public static synchronized void logEvents(String eventType, String message){
        String threadName = Thread.currentThread().getName();
        if (eventType.equals(INFO_STEP)){
            context.get(threadName).log(Status.INFO, message);
        }
        if (eventType.equals(PASS_STEP)){
            context.get(threadName).log(Status.PASS, message);
        }
    }

    public static synchronized void finishTest(String testName){
        logEvents(INFO_STEP, "--- FINISH TEST --- " +testName);
    }


    public static synchronized void generateReport(){
        extentReports.flush();
    }

    public static synchronized void logFailWithScreenshot(String message, WebDriver driver){
        String threadName = Thread.currentThread().getName();
        context.get(threadName).fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenShot(driver)).build());
    }

    private static String getScreenShot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}
