package com.example.tests;

import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @Test
    public void testSendNonEmptyQuery() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getSearchPageHelper().createQuery("tratata");
        app.getSearchPageHelper().submitQuery();
    }

    @Test
    public void testSendEmptyQuery() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getSearchPageHelper().createQuery("");
        app.getSearchPageHelper().submitQuery();
    }

}