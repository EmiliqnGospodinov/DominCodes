package dominos;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DominosMakeOrderPanel extends BasePage {
    public DominosMakeOrderPanel(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
