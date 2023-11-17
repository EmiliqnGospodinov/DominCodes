package base;

import core.BaseSetup;
import mail.creation.sites.abv.AbvHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static core.BaseSetup.driver;

public class TestsSetup{
    //WebDriver driver = new FirefoxDriver();
    //protected AbvHomePage regSite = new AbvHomePage(driver);
    //protected MainRegistrationPage regForm = new MainRegistrationPage(driver);

    @BeforeMethod
    public void setUp(){
        BaseSetup.startBrowser();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        BaseSetup.record(result);
    }

    @BeforeClass
    public void start(){

    }

    @AfterClass
    public void tearDown(){
        BaseSetup.closeBrowser();
    }

}
