package com.example.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;


import java.util.List;

/**
 * Created by yulia on 1/25/15.
 */
public class OpenMail extends TestBase {
    @Test
    public void enterMail() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().openMailLink();
        app.getMailLoginHelper().typeUserName("julia.a.orlova");
        app.getMailLoginHelper().typeUserPassword("asasas");
        app.getNavigationHelper().clickCheckBoxNotMyPC();
        app.getMailLoginHelper().clickEnterButton();
    }

    @Test
    public void sendMail() throws Exception {
//        app.getNavigationHelper().openMainPage();
//        app.getNavigationHelper().openMailLink();
        app.driver.get("https://mail.yandex.ru");
        app.getMailLoginHelper().typeUserName("julia.a.orlova");
        app.getMailLoginHelper().typeUserPassword("asasas");
//        app.getNavigationHelper().clickCheckBoxNotMyPC();
        app.getMailLoginHelper().clickEnterButton();
        //save old state
        List<MailData> oldList = app.getMailPageHelper().getMails();
        //send mail
        app.getMailPageHelper().sendMail();
        //save new state
        List<MailData> newList = app.getMailPageHelper().getMails();
        //compare states
        assertEquals(oldList.size(), newList.size());

    }
}
