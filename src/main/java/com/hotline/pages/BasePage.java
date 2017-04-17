package com.hotline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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

    public String getPAGE_URL(){
        return PAGE_URL;
    }

    public String getPAGE_TITLE(){
        return PAGE_TITLE;
    }

    public void loadPage(){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(getPAGE_URL());
        Assert.assertEquals(driver.getTitle(), getPAGE_TITLE());
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void setElementText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }
}
