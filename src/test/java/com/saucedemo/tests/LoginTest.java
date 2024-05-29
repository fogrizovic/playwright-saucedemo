package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void wrongCredentialsTest() {
        loginPage.doLogin("asd", "asd");
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError, "Epic sadface: Username and password do not match any user in this service");
    }

}
