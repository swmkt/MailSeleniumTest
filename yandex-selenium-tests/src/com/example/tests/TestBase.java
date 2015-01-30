package com.example.tests;

import com.example.fw.ApplicationManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

/**
 * Created by yulia on 1/25/15.
 */
public class TestBase {

    protected ApplicationManager app;


    @BeforeTest
    public void setUp() throws Exception {
        app = new ApplicationManager();
        }

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();

    }


}
