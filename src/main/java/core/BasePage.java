package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BasePage {

    protected WebDriver driver;

    protected BasePage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Open site
     * @param url - path to the site
     */
    public void open(String url){
        driver.get(url);
    }

    /**
    * Accept page privacy policy when its iframe
    * @param iframe - the iframe element
    * @param acceptRulesButton - the accept button element
    */
    public void iframeAcceptRules(WebElement iframe, WebElement acceptRulesButton){
        driver.switchTo().frame(iframe);
        //wait for it to load
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(acceptRulesButton));
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



    //NEEDS REFACTORING
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
