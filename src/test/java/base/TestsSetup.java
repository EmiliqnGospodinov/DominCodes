package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import static com.google.common.io.Files.move;

public class TestsSetup{
    public static WebDriver driver;

    /**
     * Start new Session
     */
    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){

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

    @BeforeClass
    public void start(){

    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }

}
