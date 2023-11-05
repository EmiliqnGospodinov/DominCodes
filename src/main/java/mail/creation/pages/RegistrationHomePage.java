package mail.creation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationHomePage {

    private WebDriver driver;
    public RegistrationHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "iframe[id=\"abv-GDPR-frame\"]")
    WebElement iframe;
    //private final By iframe = By.cssSelector("iframe[id=\"abv-GDPR-frame\"]");

    @FindBy(xpath = "//strong[contains(text(),\"Регистрирай се!\")]")
    WebElement registerButton;
    //private final By registerButton = By.xpath("//strong[contains(text(),'Регистрирай се!')]");

    @FindBy(id = "didomi-notice-agree-button")
    WebElement acceptRulesButton;
    //private final By acceptRulesButton = By.id("didomi-notice-agree-button");

    public void openRegSite(String link){
        driver.get(link);
    }

    //optional method to accept rules from iframe
    public void acceptSiteRulesAndGoBackToDefaultContent(){
        //switch to accept rules iframe
        driver.switchTo().frame(iframe);

        //wait for it to load
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(acceptRulesButton));
        acceptRulesButton.click();

        //switch back to main frame
        driver.switchTo().defaultContent();
    }

    public String checkRegistrationButtonText() {
        return registerButton.getText();
    }

    public MainRegistrationPage clickRegistrationButton(){
        registerButton.click();
        return new MainRegistrationPage(driver);
    }

}
