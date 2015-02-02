package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by yulia on 1/25/15.
 */
public class MailLoginHelper extends HelperBase {
    public MailLoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public MailLoginHelper clickEnterButton() {
        driver.findElement(By.name("profile.send")).click();
        return this;
    }

    public MailLoginHelper typeUserPassword(String userPassword) {
        type(By.id("password"), userPassword);
        return this;
    }

    public MailLoginHelper typeUserName(String userName) {
        type(By.id("login"), userName);
        return this;
    }
}
