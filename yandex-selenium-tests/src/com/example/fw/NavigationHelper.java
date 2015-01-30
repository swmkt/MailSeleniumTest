package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by yulia on 1/25/15.
 */
public class NavigationHelper extends HelperBase{
    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openMainPage() {
        //open main page
        driver.get(manager.baseUrlYandexSearch + "/");
    }

    public void openMailLink() {
        driver.get(manager.baseUrlRamblerMail + "/");
    }

    public void clickCheckBoxNotMyPC() {
        click(By.id("b-mail-domik-permament11"));
    }
}
