package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    private String usernameInput = "[data-test='username']";
    private String passwordInput = "[data-test='password']";
    private String loginButton = "[data-test='login-button']";
    private String errorMessage = "[data-test='error']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void doLogin(String user, String pass) {
        page.fill(usernameInput, user);
        page.fill(passwordInput, pass);
        page.click(loginButton);
    }

    public String getErrorMessage(){
        return page.textContent(errorMessage);
    }



}
