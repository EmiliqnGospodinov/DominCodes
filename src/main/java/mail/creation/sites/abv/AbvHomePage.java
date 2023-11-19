package mail.creation.sites.abv;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbvHomePage extends BasePage {
    static String PAGE_URL = "https://www.abv.bg/";

    public AbvHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "abv-GDPR-frame")
    WebElement RULES_IFRAME;
    //private final By iframe = By.cssSelector("iframe[id=\"abv-GDPR-frame\"]");

    @FindBy(id = "didomi-notice-agree-button")
    WebElement acceptRulesButton;
    //private final By acceptRulesButton = By.id("didomi-notice-agree-button");

    @FindBy(xpath = "//strong[contains(text(),\"Регистрирай се!\")]")
    WebElement registerButton;
    //private final By registerButton = By.xpath("//strong[contains(text(),'Регистрирай се!')]");

    public void openPage(){
        driver.get(PAGE_URL);
    }


    public void acceptRules() {
        iframeAcceptRules(RULES_IFRAME, acceptRulesButton);
    }


    public WebElement getRegistrationButton() {
        return registerButton;
    }
}
