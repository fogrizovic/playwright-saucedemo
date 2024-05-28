package com.saucedemo.tests;

import com.microsoft.playwright.Page;
import com.saucedemo.factory.PlaywrightFactory;
import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    PlaywrightFactory pf;
    Page page;
    LoginPage loginPage;


    @BeforeTest
    public void setup(){
        pf = new PlaywrightFactory();
        page = pf.initBrowser("chromium");
        loginPage = new LoginPage(page);
    }

    @Test
    public void wrongCredentialsTest() {
        loginPage.doLogin("asd", "asd");
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError, "Epic sadface: Username and password do not match any user in this service");
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
