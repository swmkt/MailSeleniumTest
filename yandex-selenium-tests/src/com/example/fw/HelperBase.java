package com.example.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
/**
 * Created by yulia on 1/25/15.
 */
public class HelperBase {
    protected ApplicationManager manager;
    protected WebDriver driver;
    protected boolean acceptNextAlert = true;

    public HelperBase(ApplicationManager manager){
        this.manager = manager;
        this.driver = manager.driver;
    }
    private boolean isAlertPresent() {
        try {
            manager.driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
    private boolean isElementPresent(By by) {
        try {
            manager.driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = manager.driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    protected void click(By by) {
        driver.findElement(by).click();
    }

    protected void type(By by, String text) {
        if(text != null){
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(text);
        }
    }
}
