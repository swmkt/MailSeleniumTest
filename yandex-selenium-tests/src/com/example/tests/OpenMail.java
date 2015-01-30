package com.example.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;


import java.io.Console;
import java.util.List;

/**
 * Created by yulia on 1/25/15.
 */
public class OpenMail extends TestBase {
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
        app.getMailPageHelper().sendMail();
        //save new state
        List<MailData> newList = app.getMailPageHelper().getMails();
        //compare states
        assertEquals(oldList.size() + 1, newList.size());
    }
}
