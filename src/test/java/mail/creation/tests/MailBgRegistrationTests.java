package mail.creation.tests;

import base.TestsSetup;
import mail.creation.sites.mailbg.MailbgHomePage;
import mail.creation.sites.mailbg.MailbgRegistrationPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MailBgRegistrationTests extends TestsSetup {

    MailbgHomePage mailbgHomePage;

    @Test
    public void mailbgRegistrationButtonCheckTextTest(){
        mailbgHomePage = new MailbgHomePage(driver);
        mailbgHomePage.openPage();

        assertTrue(mailbgHomePage.getRegistrationButton().isDisplayed());
    }

    @Test
    public void buttonRegisterTest(){
        mailbgHomePage = new MailbgHomePage(driver);
        mailbgHomePage.openPage();

        MailbgRegistrationPage mailbgRegPage = mailbgHomePage.clickButtonRegister();

        assertEquals(mailbgRegPage.getTitle(), "Mail.bg: Регистрация на нов имейл адрес");
    }
}
