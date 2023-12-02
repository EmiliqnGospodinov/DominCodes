package mail.creation.tests;

import base.TestsSetup;
import mail.creation.sites.abv.AbvHomePage;
import mail.creation.sites.abv.AbvRegistrationPage;
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

        String phoneCode = "Великобритания";//Fill phone country
        String phoneNum = "";//Fill wanted Phone  number

        abvRegPage.inputMail("kodd4eda");
        abvRegPage.inputSamePasswords("Test1234");
        abvRegPage.choosePhoneCountry(phoneCode);
        abvRegPage.inputPhone(phoneNum);
        abvRegPage.inputNames("Nice", "Name");
        abvRegPage.chooseSex("Жена");
        abvRegPage.inputBirthDate("5","Март","1953");
        abvRegPage.clickNext();

        //Make sure the inputted phone is matching on the new page
        assertEquals(abvRegPage.getPhoneNumber(), phoneNum);
        assertTrue(abvRegPage.getPhoneCode().contains(phoneCode));
        assertTrue(abvRegPage.getButtonSendCode().isDisplayed());
    }

}
