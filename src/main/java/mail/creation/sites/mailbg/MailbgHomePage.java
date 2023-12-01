package mail.creation.sites.mailbg;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailbgHomePage extends BasePage {

    String PAGE_URL = "https://mail.bg/auth/lgn";

    @FindBy(css = "a[class='signup-link']")
    public WebElement registerButton;
    public MailbgHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }




    public void openPage() {
        driver.get(PAGE_URL);
    }

    public WebElement getRegistrationButton() {
        return registerButton;
    }

    @FindBy(id = "login-overlay")
    WebElement overlay;

    public MailbgRegistrationPage clickButtonRegister() {
        //driver.manage().window().maximize();
        waitElementInvisible(overlay);
        waitElementClickable(registerButton);
        registerButton.click();
        return new MailbgRegistrationPage(driver);
    }
}
