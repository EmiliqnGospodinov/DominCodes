package core;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static com.google.common.io.Files.move;

public class BaseSetup {
    public static WebDriver driver;

    /**
     * Start new Session
     */
    public static void startBrowser() {
        BaseSetup.driver = new FirefoxDriver();
    }

    //Think about re-writing it later
    /**
     * Screenshot failed tests
     * @param result - check result of test
     */
    public static void record(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            //System.out.println("FAILNA");
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                move(screenshot, new File("C:\\Users\\emili\\Desktop\\Dominhoes\\FailedTests\\" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }


    /**
     * Closes the session
     */
    public static void closeBrowser() {
        //driver.quit();
    }
}
