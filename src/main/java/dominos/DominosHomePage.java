package dominos;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DominosHomePage extends BasePage {

    private static final String PAGE_URL = "https://www.dominos.bg/";

    @FindBy(id = "onesignal-slidedown-cancel-button")
    private WebElement popUpButton;

    @FindBy(css = "a.cart-btn:not(#cart-banner)")
    private WebElement makeOrderButton;

    @FindBy(css = "#popupModal .register")
    private WebElement registerButton;

    @FindBy(id = "onesignal-slidedown-container")
    private WebElement popUp;


    @FindBy(id = "login-email")
    private WebElement mailField;

    @FindBy(id = "login-pass")
    private WebElement passwordField;

    @FindBy(css = ".button.login")
    private WebElement loginButton;

    public DominosHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public void clickMakeOrderButton() {
        // Click the login button using JavaScript because WebDriver.click() doesn't work
        jsClick(makeOrderButton);

        // Wait until the obscuring element becomes either invisible or not present
        waitElementInvisible(popUp);

        // Wait until the login button is visible
        waitElementVisible(makeOrderButton);
    }

    public void clickRegisterButton() {
        jsClick(registerButton);
    }

    public void clearPopUp() {
        waitElementClickable(popUpButton);
        popUpButton.click();
    }

    public void inputMail(String mail) {
        mailField.sendKeys(mail);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.manage().window().maximize();
        loginButton.click();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
}
