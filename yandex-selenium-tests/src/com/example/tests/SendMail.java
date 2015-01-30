package com.example.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;


import java.util.Collections;
import java.util.List;

/**
 * Created by yulia on 1/25/15.
 */
public class SendMail extends TestBase {
    @Test
    public void enterMail() throws Exception {
        loginToMailBox();
    }

    private void loginToMailBox() {
        app.getNavigationHelper().openMailLink();
        app.getMailLoginHelper().typeUserName("testovajapochta1");
        app.getMailLoginHelper().typeUserPassword("asasas");
        app.getMailLoginHelper().clickEnterButton();
    }

    @Test
    public void sendMail() throws Exception {
        loginToMailBox();
        List<MailData> oldList = app.getMailPageHelper().getMails();
        //send mail
        MailData mailToSend = new MailData("Посланное письмо из sendMail", "1");
        app.getMailPageHelper().sendMail(mailToSend);
        //save new state
        List<MailData> newList = app.getMailPageHelper().getMails();
        //compare states
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(oldList, newList);
    }

    @Test
    public void sendAndDeleteMail() throws Exception {
        loginToMailBox();
        MailData mailToDelete = new MailData("Удали это письмо", "Содержание удаленного письма");
        app.getMailPageHelper().sendMail(mailToDelete);
        app.getNavigationHelper().openMailOutboxLink();
        app.getMailPageHelper().deleteMail(mailToDelete);
    }
}
