package com.saucedemo.tests;

import com.microsoft.playwright.Page;
import com.saucedemo.factory.PlaywrightFactory;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.PropertyReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    PlaywrightFactory pf;
    Page page;
    LoginPage loginPage;

    @BeforeTest
    public void setup(){
        pf = new PlaywrightFactory();
        page = pf.initBrowser(PropertyReader.getProperty("browser"));
        loginPage = new LoginPage(page);
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
