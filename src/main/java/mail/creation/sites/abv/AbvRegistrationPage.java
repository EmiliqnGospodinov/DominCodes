package mail.creation.sites.abv;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AbvRegistrationPage extends BasePage{
    static String PAGE_URL = "https://passport.abv.bg/app/profiles/registration";

    public AbvRegistrationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id= "regformUsername")
    WebElement mailField;
    //private By mailField; // = By.cssSelector("input[id=\"regformUsername\"]");


    @FindBy(id = "password")
    WebElement passField;
    //private By passField;// = By.id("password");

    @FindBy(id = "password2")
    WebElement confirmPass;
    // = RelativeLocator.with(By.id("password2")).below(By.id("password"));

    @FindBy(id= "mobilePhone")
    WebElement phoneNumber;
    //private By phone;// = By.cssSelector("input[id=\"mobilePhone\"]");

    @FindBy(css = ".abv-phone>strong")
    WebElement phoneCode;

    @FindBy(css = ".abv-phone>ul>li")
    List<WebElement> countriesList;

    @FindBy(id = "fname")
    WebElement fName;
    //private By firstName = By.id("fname");

    @FindBy(id = "lname")
    WebElement lName;

    @FindBy(css = "div[class='abv-radio']>label")
    List<WebElement> sexes;

    @FindBy(id = "bDay")
    WebElement bDay;

    //String text = driver.findElement(By.xpath("//li[.='"+option+"']")).getAttribute("textContent");
    @FindBy(css = "#bDay>ul>li")
    List<WebElement> bDayList;

    @FindBy(id = "bMonth")
    WebElement bMonth;

    @FindBy(css = "#bMonth>ul>li")
    List<WebElement> bMonthList;
    @FindBy(id = "bYear")
    WebElement bYear;

    @FindBy(css = "#bYear>ul>li")
    List<WebElement> bYearList;

    @FindBy(css = "input[value='Напред']")
    WebElement buttonNext;

    public void inputMail(String mail){
        mailField.sendKeys(mail);
    }

    public void inputPassword(String password){
        passField.sendKeys(password);
    }

    public void inputConfirmPassword(String password){
        confirmPass.sendKeys(password);
    }

    public void inputSamePasswords(String password){
        inputPassword(password);
        inputConfirmPassword(password);
    }

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public void choosePhoneCountry(String country){
        selectDropdownOption(countriesList, phoneCode, country);
    }

    public void inputPhone(String phoneNumber){
        this.phoneNumber.sendKeys(phoneNumber);
    }

    public void inputNames(String firstName, String lastName){
        fName.sendKeys(firstName);
        lName.sendKeys(lastName);
    }


    public void chooseSex(String sex){
        WebElement chosenSex = sexes.stream().
                filter((element) -> element.getText().contains(sex))
                .findFirst().orElse(null);
        chosenSex.click();
    }

    public void inputBirthDate(String bDayOption, String bMonthOption, String bYearOption){
        selectDropdownOption(bDayList, bDay, bDayOption);
        selectDropdownOption(bMonthList, bMonth, bMonthOption);
        selectDropdownOption(bYearList, bYear, bYearOption);
    }

    public void clickNext() {
        buttonNext.click();
    }

    //Assertions code

    @FindBy(css = "input[value='Изпрати код']")
    WebElement buttonSendCode;

    @FindBy(id = "shortCountryMobilePhoneCode")
    WebElement phoneCodeCountry;

    public WebElement getButtonSendCode() {
        return buttonSendCode;
    }

    public String getPhoneNumber(){
        return phoneNumber.getAttribute("value");
    }

    public String getPhoneCode(){
       return phoneCodeCountry.getAttribute("value");
    }
}
