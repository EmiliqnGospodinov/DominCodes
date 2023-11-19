package mail.creation.tests;

import base.TestsSetup;
import mail.creation.sites.abv.AbvHomePage;
import mail.creation.sites.abv.AbvRegistrationPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AbvRegistrationTests extends TestsSetup {

    AbvHomePage abvHomePage;
    AbvRegistrationPage abvRegPage;


    @Test
    public void abvRegistrationButtonCheckTextTest(){
        abvHomePage = new AbvHomePage(driver);
        abvHomePage.openPage();

        abvHomePage.acceptRules();

        assertTrue(abvHomePage.getRegistrationButton().isDisplayed());

    }

    @Test
    public void abvCompleteRegistionTest(){
        abvRegPage = new AbvRegistrationPage(driver);
        abvRegPage.openPage();
        //When opening the Registration Page directly there is no Rules pop-up??

        abvRegPage.inputMail("kod4eta");
        abvRegPage.inputSamePasswords("Test1234");
        abvRegPage.inputPhone("888888888");//Fill phone num
        abvRegPage.chooseSex(2);
        abvRegPage.inputNames("Nice", "Name");
        abvRegPage.inputBirthDate("5","Март","1953");
    }


    //@Test
    //public void abvRegButtonClickTest(){
    //    regSite.openRegSite("https://www.abv.bg");
    //    regSite.acceptSiteRulesAndGoBackToDefaultContent();
    //    regSite.clickRegistrationButton();
    //    regForm.inputEmailName("kod4eta");
    //    regForm.inputPasswords("Testpass1", "Testpass1");
    //    regForm.inputAdditionalInfo("888888888","Asdf","Fdsa");
//
    //    regForm.chooseSex("2");
    //    assertEquals("2", regForm.getSex());
//
    //    assertEquals("5", regForm.menuClickOption("bDay", "5"), "Wrong day clicked");
    //    assertEquals("Януари", regForm.menuClickOption("bMonth", "Януари"), "Wrong month clicked");
    //    assertEquals("1969", regForm.menuClickOption("bYear", "1969"), "Wrong year clicked");
    //}
}
