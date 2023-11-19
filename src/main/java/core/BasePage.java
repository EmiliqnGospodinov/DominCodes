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
    protected static void selectDropdownOption(WebElement menu, String option){
            menu.click();
            //needs Refactoring
            //String text = driver.findElement(By.xpath("//li[.='"+option+"']")).getAttribute("textContent");
            menu.findElement(By.xpath("//li[.='"+option+"']")).click();

            //store and chose option
            //WebElement menu = driver.findElement(By.xpath("//div[@id=\""+ul+"\"]"));
            //WebElement menuOption = menu.findElement(By.xpath("//li[.='"+option+"']"));
            //String textInMenu = menuOption.getText();
            //menuOption.click();

            //return result for assertion
            //return textInMenu;

             //List<WebElement> bDays = menu.findElements(By.tagName("li"));
             //List<String> bDaysList = bDays.stream().map(WebElement::getText).collect(Collectors.toList());
             //System.out.println(bDaysList);
             //int intOption = Integer.parseInt(option);
             //bDays.get(intOption).click();


    }
}
