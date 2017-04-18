package com.hotline.tests;

import com.hotline.HotlineMainPage;
import com.hotline.data.HotlineData;
import com.hotline.pages.HotlineMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dmytro_Kapeliukh on 4/17/17.
 */
public class SelectProducts {
    public WebDriver driver;
    HotlineMenuPage htMenuPage;
    HotlineMainPage htMainPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = new FirefoxDriver();
        htMenuPage = PageFactory.initElements(driver, HotlineMenuPage.class);
        htMainPage = PageFactory.initElements(driver, HotlineMainPage.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void theardown() throws InterruptedException {
        Thread.sleep(6000L);
        driver.quit();
    }

    @Test(dataProviderClass = HotlineData.class, dataProvider = "login")
    public void selectIphone(String email, String password) throws InterruptedException {
        htMainPage.loadPage();
        htMainPage.login(email, password);
        Thread.sleep(3000L);
        htMenuPage.setTextSearchFiled("Iphone");
        htMenuPage.clickSearchButton();
        htMenuPage.clickSelectIphone();
    }
}
