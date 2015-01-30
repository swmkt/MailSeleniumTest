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
//        driver.findElement(By.linkText("Войти")).click();
        click(By.cssSelector("input.b-mail-button__button"));
    }

    public void typeUserPassword(String userPassword) {
        type(By.id("b-mail-domik-password11"), userPassword);
    }

    public void typeUserName(String userName) {
        type(By.id("b-mail-domik-username11"), userName);
    }
}
