package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.example.tests.MailDataGenerator.generateRandomMails;
import static com.example.tests.MailDataGenerator.loadGroupsFromCsvFile;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by yulia on 1/25/15.
 */
public class MailTests extends TestBase {
    @Test
    public void enterMail() throws Exception {
        loginToMailBox();
    }
    @BeforeTest
    private void loginToMailBox() {
        app.getNavigationHelper().openMailPage();
        app.getMailLoginHelper().typeUserName("testovajapochta1")
                .typeUserPassword("asasas")
                .clickEnterButton();
    }

    @DataProvider
    public Iterator<Object[]> randomValidMailGenerator(){
        return wrapMailDataForProvider(generateRandomMails(5)).iterator();
    }

    @DataProvider
    public  Iterator<Object[]> mailDataFromFile() throws IOException {
        return wrapMailDataForProvider(loadGroupsFromCsvFile(new File("mails.txt"))).iterator();
    }


    private List<Object[]> wrapMailDataForProvider(List<MailData> mails) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (MailData mail : mails) {
            list.add(new Object[]{mail});
        }
        return list;
    }


    @Test
    public void sendMail() throws Exception {
        List<MailData> oldList = app.getMailPageHelper().getMails();
        //send mail
        MailData mailToSend = new MailData().withRecipient("testovajapochta1@rambler.ru").withTopic("Посланное письмо из sendMail").withContent("1");
        app.getMailPageHelper().sendMail(mailToSend);
        //save new state
        List<MailData> newList = app.getMailPageHelper().getMails();
        //compare states
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(oldList, newList);
    }

    @Test(dataProvider = "mailDataFromFile")
    public void sendRandomMails(MailData mailToSend) throws Exception {
        app.getMailPageHelper().sendMail(mailToSend);
    }

    @Test(dataProvider = "randomValidMailGenerator")
    public void sendAndDeleteMail(MailData mailToDelete) throws Exception {
        app.getMailPageHelper().sendMail(mailToDelete);
        app.getNavigationHelper().openMailOutboxLink();
        app.getMailPageHelper().checkMail(mailToDelete)
                .deleteHighlightedMail();
    }

    @Test
    public void deleteAllMails() throws Exception {
        app.getNavigationHelper().openMailInboxLink();
        app.getMailPageHelper().checkAllMails();
        app.getMailPageHelper().deleteHighlightedMail();
    }
}
