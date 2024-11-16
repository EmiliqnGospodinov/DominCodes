package dominos.test;

import base.TestsSetup;
import dominos.DominosHomePage;
import dominos.DominosMakeOrderPanel;
import dominos.DominosRegistrationPage;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DominosLoginTests extends TestsSetup {

    DominosHomePage dominosHomePage;
    DominosRegistrationPage dominosRegistrationPage;
    DominosMakeOrderPanel dominosMakeOrderPanel;


    //Test works if the mail is not already in use
    @Test(priority = 3)
    public void dominosMakeRegistrationTest(){
        dominosHomePage = new DominosHomePage(driver);
        dominosHomePage.openPage();
        dominosHomePage.clearPopUp();

        dominosHomePage.clickMakeOrderButton();
        dominosHomePage.clickRegisterButton();

        //Check if we are on the registration form page
        dominosRegistrationPage = new DominosRegistrationPage(driver);
        assertEquals(dominosRegistrationPage.getPageUrlAfterLoading(), "https://www.dominos.bg/signup");

        dominosRegistrationPage.inputName("Слави", "Трифонов");
        dominosRegistrationPage.inputEmail("test@mail.test");//input not used mail
        dominosRegistrationPage.inputPasswords("CveteMoe");
        dominosRegistrationPage.acceptRules();
        dominosRegistrationPage.clickCompleteRegistrationButton();

        assertTrue(dominosRegistrationPage.chooseTakeawayOptionIsVisible());

    }

    @Test(priority = 2)
    public void successfulLogin(){
        dominosHomePage = new DominosHomePage(driver);
        dominosHomePage.openPage();
        dominosHomePage.clearPopUp();

        dominosHomePage.clickMakeOrderButton();
        dominosHomePage.inputMail("kodd4eda@abv.bg");
        dominosHomePage.inputPassword("CveteMoe");
        dominosHomePage.clickLoginButton();

        //Make sure the login was successful
        dominosMakeOrderPanel = new DominosMakeOrderPanel(driver);
        assertEquals(dominosHomePage.getPageUrl(), "https://www.dominos.bg/#step1");
    }

    @Test(priority = 1)
    public void loginTest(){
        dominosHomePage = new DominosHomePage(driver);
        dominosHomePage.openPage();

        //login with cookie
        driver.manage().addCookie(new Cookie("PHPSESSID", "va75fal2g4l9q211b50sdnc8v5"));
    }
}
