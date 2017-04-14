package com.hotline.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Dmytro_Kapeliukh on 4/14/2017.
 */
public class BasePage {
    public WebDriver driver;
    public String PAGE_URL;
    public String PAGE_TITLE;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
}
