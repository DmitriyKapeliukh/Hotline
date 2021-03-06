package com.hotline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Dmytro_Kapeliukh on 4/14/2017.
 */
public abstract class BasePage {
    WebDriver driver;
    String PAGE_URL;
    String PAGE_TITLE;
    WebDriverWait wait;


    BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private String getPAGE_URL(){
        return PAGE_URL;
    }

    public String getPAGE_TITLE(){
        return PAGE_TITLE;
    }

    public void loadPage(){
        driver.get(getPAGE_URL());
        Assert.assertEquals(driver.getTitle(), getPAGE_TITLE());
    }

    void clickElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    void setElementText(WebElement element, String text){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }
}
