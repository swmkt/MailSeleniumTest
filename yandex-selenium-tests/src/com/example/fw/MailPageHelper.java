package com.example.fw;

import com.example.tests.MailData;
import com.example.tests.TestBase;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yulia on 1/28/15.
 */
public class MailPageHelper extends HelperBase {
    public MailPageHelper(ApplicationManager manager){
        super(manager);
    }

    public List<MailData> getMails() {
        List<MailData> mails = new ArrayList<MailData>();
        List<WebElement> topics = driver.findElements(By.className("b-messages__subject"));
        for(WebElement topic : topics)
        {
            MailData mail = new MailData();
            mail.text = topic.getText();
            mails.add(mail);
        }
        return mails;
    }

    public void sendMail() {

    }
}
