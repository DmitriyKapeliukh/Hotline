package com.hotline.utilites;

import com.hotline.BrowserConstants;
import junitx.util.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public enum BrowserType{
        FIREFOX("firefox"),
        CHROME("chrome"),
        IE("internet_explorer"),
        SAFARI("safari");

        private String value;

        BrowserType(String value){
            this.value = value;
        }

        public String getBrowserName(){
            return this.value;
        }
    }

    public static WebDriver getWebDriver(BrowserType type){
        WebDriver driver;
        switch (type){
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", BrowserConstants.CHROME_PATH);
                driver = new ChromeDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }

    public static BrowserType getBrowserTypeByProperty(){
        BrowserType type = null;
        String browserName = PropertyManager.getProperty("BROWSER");
        for (BrowserType browserType : BrowserType.values()){
            if (browserType.getBrowserName().equalsIgnoreCase(browserName)){
                type = browserType;
                System.out.println("BROWSER "+type.getBrowserName());
            }
        }
        return type;
    }
}
