package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by yulia on 1/25/15.
 */
public class MailLoginHelper extends HelperBase {
    public MailLoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void clickEnterButton() {
        driver.findElement(By.name("profile.send")).click();

    }

    public void typeUserPassword(String userPassword) {
        type(By.id("password"), userPassword);
    }

    public void typeUserName(String userName) {
        type(By.id("login"), userName);
    }
}
