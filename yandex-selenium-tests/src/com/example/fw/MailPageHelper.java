package com.example.fw;

import com.example.tests.MailData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yulia on 1/28/15.
 */
public class MailPageHelper extends HelperBase {
    public MailPageHelper(ApplicationManager manager){
        super(manager);
    }

    private List<MailData> cachedMails;
    public List<MailData> getMails() {
        if(cachedMails == null) {
            rebuildCache();
        }
        return cachedMails;
    }

    private void rebuildCache() {
        List<MailData> cachedMails = new ArrayList<MailData>();
        List<WebElement> topics = driver.findElements(By.className("listItem"));
        for(WebElement topic : topics)
        {
            MailData mail = new MailData();
            mail.withTopic(topic.getText());
            cachedMails.add(mail);
        }
    }

    public MailPageHelper sendMail(MailData mail) {
        clickNewMailButton();
        chooseMailRecipient(mail.getRecipient());
        typeMail(mail);
        clickSendMailButton();
        return this;
    }

    private void chooseMailRecipient(String recipient) {
        driver.findElement(By.cssSelector("input.uiAutocompleteTextInput")).sendKeys(recipient);
    }

    private void clickSendMailButton() {
        click(By.xpath("//html[@id='js']/body/div[8]/div/div[4]/button[2]"));
    }

    private void typeMail(MailData mail) {
        type(By.id("subject"), mail.getTopic());
//        type(By.cssSelector("div.uiTextarea.composeTextarea"), mail.content);
    }

    private void clickNewMailButton() {
        click(By.cssSelector("button.uiButton.uiButtonNormal"));
    }

    public MailPageHelper deleteHighlightedMail() {
        click(By.className("iconDelete"));
        return this;
    }

    public MailPageHelper checkMail(MailData mailToDelete){
        click(By.linkText(mailToDelete.getTopic()));
        return this;

    }

    public MailPageHelper checkAllMails() {
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        return this;

    }
}
