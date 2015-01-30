package com.example.fw;

import com.example.tests.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by yulia on 1/25/15.
 */
public class ApplicationManager {

    public WebDriver driver;
    public String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    private NavigationHelper navigationHelper;
    private MailLoginHelper mailLoginHelper;
    private SearchPageHelper searchPageHelper;
    private MailPageHelper mailPageHelper;

    public ApplicationManager(){
        driver = new FirefoxDriver();
        baseUrl = "http://ya.ru";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void stop() {
        driver.quit();
    }

    //lazy initialization
    public NavigationHelper getNavigationHelper(){
        if(navigationHelper == null)
            navigationHelper = new NavigationHelper(this);
        return navigationHelper;
    }
    public MailLoginHelper getMailLoginHelper(){
        if(mailLoginHelper == null)
            mailLoginHelper = new MailLoginHelper(this);
        return mailLoginHelper;
    }
    public SearchPageHelper getSearchPageHelper(){
        if(searchPageHelper == null)
            searchPageHelper = new SearchPageHelper(this);
        return searchPageHelper;
    }

    public MailPageHelper getMailPageHelper() {
        if(mailPageHelper == null)
            mailPageHelper = new MailPageHelper(this);
        return mailPageHelper;
    }
}
