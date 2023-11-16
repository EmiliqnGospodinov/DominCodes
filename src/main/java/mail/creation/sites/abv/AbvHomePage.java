package mail.creation.sites.abv;

import core.BaseSetup;
import core.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbvHomePage extends CommonActions {

    public AbvHomePage(WebDriver driver){
        //this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    static String PAGE_URL = "https://www.abv.bg/";

    @FindBy(id = "abv-GDPR-frame")
    static WebElement RULES_IFRAME;

    @FindBy(id = "didomi-notice-agree-button")
    static WebElement acceptRulesButton;

    //@FindBy(xpath = "//strong[contains(text(),\"Регистрирай се!\")]")
    //WebElement registerButton;


    //private final By iframe = By.cssSelector("iframe[id=\"abv-GDPR-frame\"]");
    //private final By registerButton = By.xpath("//strong[contains(text(),'Регистрирай се!')]");
    //private final By acceptRulesButton = By.id("didomi-notice-agree-button");

    @FindBy(css = "input[id='regformUsername']")
    WebElement mailField;
    //private By mailField; // = By.cssSelector("input[id=\"regformUsername\"]");


    @FindBy(id = "password")
    WebElement passField;
    //private By passField;// = By.id("password");

    @FindBy(id = "password2")
    WebElement confirmPass;
    // = RelativeLocator.with(By.id("password2")).below(By.id("password"));

    @FindBy(css = "input[id=\"mobilePhone\"]")
    WebElement phone;
    //private By phone;// = By.cssSelector("input[id=\"mobilePhone\"]");

    @FindBy(id = "fname")
    WebElement firstName;
    //private By firstName;// = By.id("fname");

    @FindBy(id = "lname")
    WebElement lastName;

    public static void openUrl() {
        open(PAGE_URL);
    }

    public static void acceptRules() {
        iframeAcceptRules(RULES_IFRAME, acceptRulesButton);
    }
    //private By lastName;// = By.id("lname");

}
