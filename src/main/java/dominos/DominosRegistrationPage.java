package dominos;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DominosRegistrationPage extends BasePage {

    private static final String PAGE_URL = "https://www.dominos.bg/signup";

    @FindBy(id = "f_name")
    private WebElement firstName;

    @FindBy(id = "l_name")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "pass")
    private WebElement pass;

    @FindBy(id = "conf_pass")
    private WebElement pass2;

    @FindBy(className = "invoice-label")
    private WebElement rulesButton;

    @FindBy(id = "loading")
    private WebElement loading;

    @FindBy(className = "signup-btn")
    private WebElement signUpButton;

    @FindBy(css = "div.step1-choice[data-rel='C']")
    private WebElement takeawayButton;

    public DominosRegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageUrlAfterLoading(){
        wait.until(ExpectedConditions.urlToBe(PAGE_URL));
        return driver.getCurrentUrl();
    }

    public void inputName(String fName, String lName) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
    }

    public void inputEmail(String mail) {
        email.sendKeys(mail);
    }


    public void inputPasswords(String password) {
        pass.sendKeys(password);
        pass2.sendKeys(password);
    }

    public void acceptRules() {
        //wait for page to fully load
        waitElementInvisible(loading);

        //accept the rules
        rulesButton.click();
    }

    public void clickCompleteRegistrationButton() {
        signUpButton.click();
    }

    public boolean chooseTakeawayOptionIsVisible() {
        waitElementVisible(takeawayButton);
        return takeawayButton.isDisplayed();
    }
}
