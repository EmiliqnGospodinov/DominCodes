package mail.creation.tests;

import base.TestsSetup;
import core.BaseSetup;
import mail.creation.sites.abv.AbvHomePage;
import org.testng.annotations.Test;

import static core.BaseSetup.driver;
import static org.testng.Assert.assertEquals;

public class AbvRegistrationTests extends TestsSetup {

    AbvHomePage abvHomePage = new AbvHomePage(BaseSetup.driver);
    //protected RegistrationHomePage regSite = new RegistrationHomePage(driver);
    //protected MainRegistrationPage regForm = new MainRegistrationPage(driver);

    @Test
    public void abvRegistrationButtonTest(){
        abvHomePage.openUrl();
        abvHomePage.acceptRules();
    }

    //@Test
    //public void abvRegButtonText(){
//
    //    regSite.openRegSite("https://www.abv.bg/");
    //    regSite.acceptSiteRulesAndGoBackToDefaultContent();
    //    assertEquals("Регистрирай се!", regSite.checkRegistrationButtonText());
    //}
//
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
