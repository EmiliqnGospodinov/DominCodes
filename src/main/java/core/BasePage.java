package core;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor jsExecutor;

    protected BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    protected void jsClick(WebElement element){
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    /**
     * Wait for WebElement to be clickable
     * @param element - waited WebElement
     */
    protected void waitElementClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Wait for WebElement to be invisible
     * @param element
     */
    protected void waitElementVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait for WebElement to be visible
     * @param element
     */
    protected void waitElementInvisible(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
    * Accept page privacy policy when its iframe
    * @param iframe - the iframe element
    * @param acceptRulesButton - the accept button element
    */
    protected void iframeAcceptRules(WebElement iframe, WebElement acceptRulesButton){
        driver.switchTo().frame(iframe);

        //wait for it to load
        waitElementClickable(acceptRulesButton);
        acceptRulesButton.click();

        //switch back to main frame
        driver.switchTo().defaultContent();
    }

    /**
    * Types in selected field
    * @param field - WebElement field
    * @param input - The desired input
    */
    protected static void typeInField(WebElement field, String input) {
        field.sendKeys(input);
    }


    /**
     * Choose a dropdown element and the option to be selected
     * @param list - The list of dropdown elements
     * @param menu - The dropdown element
     * @param option - The option to be selected as a String
     */
    protected static void selectDropdownOption(List<WebElement> list, WebElement menu, String option){
        menu.click();
        WebElement correct = list.stream().
         filter((element) -> element.getText().contains(option))
                .findFirst().orElse(null);
        correct.click();
        //for (WebElement element: list
        //) {
        //    String textDay = element.getText();
        //    if (textDay.contains(option)){
        //        element.click();
        //        return;
        //    }
        //}
    }
}
