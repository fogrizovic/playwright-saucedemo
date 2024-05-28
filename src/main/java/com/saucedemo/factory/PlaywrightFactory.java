package com.saucedemo.factory;

import com.microsoft.playwright.*;

import javax.swing.*;
import java.util.Locale;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Page initBrowser(String browserName) {
        playwright = Playwright.create();

        System.out.println("browser name is: " + browserName);

        switch (browserName.toLowerCase(Locale.ROOT)){
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                System.out.println("wrong browser");
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();

        page.navigate("https://www.saucedemo.com/");

        return page;

    }
}
