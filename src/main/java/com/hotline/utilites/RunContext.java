package com.hotline.utilites;

import org.openqa.selenium.WebDriver;

public class RunContext {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        RunContext.driver = driver;
    }
}
