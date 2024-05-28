package com.saucedemo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasics {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch();

        Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com/");

        String title = page.title();

        System.out.println("page title is: " + title);

        browser.close();
        playwright.close();
    }
}