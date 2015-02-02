package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by yulia on 1/25/15.
 */
public class NavigationHelper extends HelperBase{
    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openMailPage() {
        if(!onMailPage())
            driver.get(manager.baseUrlRamblerMail);
    }

    public void openMailOutboxLink() {
        if(!onOutboxPage())
            driver.get(manager.baseUrlRamblerMail + "/#/folder/SentBox/");
    }

    public void openMailInboxLink() {
        if(!onInboxPage())
            driver.get(manager.baseUrlRamblerMail + "/#/folder/Inbox/");
    }

    private boolean onMailPage()
    {
        if(driver.getCurrentUrl().contains(manager.baseUrlRamblerMail) && driver.findElements(By.name("profile.send")).size() > 0)
            return true;
        else return false;
    }
    private boolean onInboxPage()
    {
        if(driver.getCurrentUrl().contains("Inbox"))
            return true;
        else return false;
    }
    private boolean onOutboxPage()
    {
        if(driver.getCurrentUrl().contains("Sent"))
            return true;
        else return false;
    }


}
