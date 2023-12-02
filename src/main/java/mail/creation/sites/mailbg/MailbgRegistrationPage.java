package mail.creation.sites.mailbg;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MailbgRegistrationPage extends BasePage {

    private static final String PAGE_URL = "https://mail.bg/signup";

    MailbgRegistrationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public String getTitle() {
        return driver.getTitle();
    }
}
