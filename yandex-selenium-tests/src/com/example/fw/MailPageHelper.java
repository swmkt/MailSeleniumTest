package com.example.fw;

import com.example.tests.MailData;
import com.example.tests.TestBase;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
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

    public List<MailData> getMails() {
        List<MailData> mails = new ArrayList<MailData>();
        List<WebElement> topics = driver.findElements(By.className("listItem"));
        for(WebElement topic : topics)
        {
            MailData mail = new MailData();
            mail.text = topic.getText();
            mails.add(mail);
        }
        return mails;
    }

    public void sendMail() {
        driver.findElement(By.cssSelector("button.uiButton.uiButtonNormal")).click();
        new Select(driver.findElement(By.cssSelector("select.composeSelectFrom"))).selectByVisibleText("John Smith (testovajapochta1@rambler.ru)");
        driver.findElement(By.cssSelector("label.uiAutocompletePlaceholder")).click();
        driver.findElement(By.cssSelector("input.uiAutocompleteTextInput")).click();
        driver.findElement(By.cssSelector("div.composeNameFrom")).click();
        driver.findElement(By.cssSelector("div.composeNameFrom")).click();
        driver.findElement(By.cssSelector("div.composeNameFrom")).click();
        driver.findElement(By.cssSelector("label.uiAutocompletePlaceholder")).click();
        driver.findElement(By.cssSelector("input.uiAutocompleteTextInput")).click();
        driver.findElement(By.cssSelector("input.uiAutocompleteTextInput")).clear();
        driver.findElement(By.cssSelector("input.uiAutocompleteTextInput")).sendKeys("testovajapochta1@rambler.ru");
        driver.findElement(By.id("subject")).click();
        driver.findElement(By.id("subject")).clear();
        driver.findElement(By.id("subject")).sendKeys("привет");
        driver.findElement(By.xpath("//html[@id='js']/body/div[8]/div/div[4]/button[2]")).click();

    }
}
