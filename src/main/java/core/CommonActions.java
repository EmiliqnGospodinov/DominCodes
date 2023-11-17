package core;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static core.BaseSetup.driver;

public class CommonActions {

    /**
     * Open site
     * @param url - path to the site
     */
    public static void open(String url){
        driver.get(url);
    }

    /**
     * Accept page privacy policy when its iframe
     * @param iframe - the iframe element
     * @param acceptRulesButton - the accept button element
     */
    public static void iframeAcceptRules(WebElement iframe, WebElement acceptRulesButton){
            driver.switchTo().frame(iframe);
            System.out.println(driver.getTitle());

            //wait for it to load
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(acceptRulesButton));
            acceptRulesButton.click();

            //switch back to main frame
            driver.switchTo().defaultContent();
        }
}
