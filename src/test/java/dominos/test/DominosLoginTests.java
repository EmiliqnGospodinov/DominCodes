package dominos.test;

import base.TestsSetup;
import dominos.DominosHomePage;
import dominos.DominosRegistrationPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DominosLoginTests extends TestsSetup {

    DominosHomePage dominosHomePage;
    DominosRegistrationPage dominosRegistrationPage;


    //Test works if the mail is not already in use
    @Test
    public void dominosMakeRegistrationTest(){
        dominosHomePage = new DominosHomePage(driver);
        dominosHomePage.openPage();
        dominosHomePage.clearPopUp();

        dominosHomePage.clickLoginButton();
        dominosHomePage.clickRegisterButton();

        //Check if we are on the registration form page
        dominosRegistrationPage = new DominosRegistrationPage(driver);
        assertEquals(dominosRegistrationPage.getPageUrlAfterLoading(), "https://www.dominos.bg/signup");

        dominosRegistrationPage.inputName("Слави", "Трифонов");
        dominosRegistrationPage.inputEmail("");//input not used mail
        dominosRegistrationPage.inputPasswords("CveteMoe");
        dominosRegistrationPage.acceptRules();
        dominosRegistrationPage.clickCompleteRegistrationButton();

        assertTrue(dominosRegistrationPage.chooseTakeawayOptionIsVisible());

    }

}
