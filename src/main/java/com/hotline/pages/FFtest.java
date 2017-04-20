package com.hotline.pages;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;


public class FFtest {

    public static WebDriver driver = null;

    public static void main(String[] args) {
        driver = new FirefoxDriver();
        driver.get("http://hotline.ua/mobile-mobilnye-telefony-i-smartfony/apple-iphone-7-32gb-black/");
        WebElement button = driver.findElement(By.cssSelector(".but-box.but-blue.m_r-15.m_b-10-330.g_statistic"));
        button.click();
        String result = fluentWaitForElementAndGetTextFromIt(By.xpath(".//*[@id='card-bookmarks-popup']/form/div[2]"), 10);
        System.out.println(result);


    }

    public static String fluentWaitForElementAndGetTextFromIt(final By selector, int timeoutInSeconds) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeoutInSeconds, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebDriver, String>() {
            public String apply(WebDriver driver) {
                WebElement element = driver.findElement(selector);
                System.out.println("__");
                if (element.isDisplayed()) {
                    return element.getText();
                } else {
                    return null;
                }
            }
        });
    }
}
