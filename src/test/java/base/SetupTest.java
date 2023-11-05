package base;

import mail.creation.pages.RegistrationHomePage;
import mail.creation.pages.MainRegistrationPage;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import static com.google.common.io.Files.*;
import static org.testng.Assert.assertEquals;

public class SetupTest {
    private WebDriver driver = new FirefoxDriver();
    protected RegistrationHomePage regSite = new RegistrationHomePage(driver);
    protected MainRegistrationPage regForm = new MainRegistrationPage(driver);

    @BeforeMethod
    public void setUp(){
        //driver.get("https://www.dominos.bg/");
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
       // driver.quit();
    }

}
