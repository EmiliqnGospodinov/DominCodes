package mail.creation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainRegistrationPage {
    private WebDriver driver;
    public MainRegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[id='regformUsername']")
    WebElement mailField;
    //private By mailField; // = By.cssSelector("input[id=\"regformUsername\"]");


    @FindBy(id = "password")
    WebElement passField;
    //private By passField;// = By.id("password");

    @FindBy(id = "password2")
    WebElement confirmPass;
    // = RelativeLocator.with(By.id("password2")).below(By.id("password"));

    @FindBy(css = "input[id=\"mobilePhone\"]")
    WebElement phone;
    //private By phone;// = By.cssSelector("input[id=\"mobilePhone\"]");

    @FindBy(id = "fname")
    WebElement firstName;
    //private By firstName;// = By.id("fname");

    @FindBy(id = "lname")
    WebElement lastName;
    //private By lastName;// = By.id("lname");

    public void inputEmailName(String mail){
        mailField.sendKeys(mail);
    }

    public void inputPasswords(String pass, String pass2){
        passField.sendKeys(pass);
        confirmPass.sendKeys(pass2);
    }

    public void inputAdditionalInfo(String phoneNum, String fName, String lName){
        phone.sendKeys(phoneNum);
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);

        //Optional Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //option 1 = woman
    //option 2 = man
    public void chooseSex(String option){
        String xpathSex = "//label[@data-value=\"" + option + "\"]";
        By sex = By.xpath(xpathSex);
        driver.findElement(sex).click();
    }

    public String getSex(){
        return driver.findElement(By.xpath("//label[contains(@class, 'selected')]")).getAttribute("data-value");
    }

    public String menuClickOption(String ul, String option){
        //open menu
        WebElement menu = driver.findElement(By.xpath("//div[@id=\""+ul+"\"]"));
        menu.click();

        //store and chose option
        WebElement menuOption = menu.findElement(By.xpath("//li[.='"+option+"']"));
        String textInMenu = menuOption.getText();
        menuOption.click();

        //return result for assertion
        return textInMenu;

        /**old way
         *
         List<WebElement> bDays = menu.findElements(By.tagName("li"));
         List<String> bDaysList = bDays.stream().map(WebElement::getText).collect(Collectors.toList());
         System.out.println(bDaysList);
         int intOption = Integer.parseInt(option);
         bDays.get(intOption).click();
         */
    }
}
