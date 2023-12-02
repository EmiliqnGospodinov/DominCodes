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
    private WebElement loginButton;

    @FindBy(css = "#popupModal .register")
    private WebElement registerButton;

    @FindBy(id = "onesignal-slidedown-container")
    private WebElement popUp;

    public DominosHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public void clickLoginButton() {
        // Click the login button using JavaScript because WebDriver.click() doesn't work
        jsClick(loginButton);

        // Wait until the obscuring element becomes either invisible or not present
        waitElementInvisible(popUp);

        // Wait until the login button is visible
        waitElementVisible(loginButton);
    }

    public void clickRegisterButton() {
        jsClick(registerButton);
    }

    public void clearPopUp() {
        waitElementClickable(popUpButton);
        popUpButton.click();
    }
}
