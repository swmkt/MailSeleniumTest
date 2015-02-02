package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by yulia on 1/25/15.
 */
public class SearchPageHelper extends HelperBase {
    public SearchPageHelper(ApplicationManager manager){
        super(manager);
    }
    public void createQuery(String string) {
        //create new query
        type(By.id("topic"), string);
    }

    public void submitQuery() {
        //submit a query
        manager.driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
