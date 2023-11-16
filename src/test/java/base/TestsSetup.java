package base;

import core.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestsSetup{
    //private WebDriver driver = new FirefoxDriver();
    //protected RegistrationHomePage regSite = new RegistrationHomePage(driver);
    //protected MainRegistrationPage regForm = new MainRegistrationPage(driver);

    @BeforeMethod
    public void setUp(WebDriver driver){
        BaseSetup.startBrowser(driver);
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
