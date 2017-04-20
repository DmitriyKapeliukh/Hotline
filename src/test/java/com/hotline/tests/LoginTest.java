package com.hotline.tests;

import com.hotline.HotlineMainPage;
import com.hotline.data.HotlineData;
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
public class LoginTest {
    public WebDriver driver;
    HotlineMainPage htMainPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = new FirefoxDriver();
        htMainPage = PageFactory.initElements(driver, HotlineMainPage.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() throws InterruptedException {
        Thread.sleep(6000L);
        driver.quit();
    }

    @Test(groups = "T1", dataProviderClass = HotlineData.class, dataProvider = "login")
    public void loginTest(String login, String password){
        htMainPage.loadPage();
        htMainPage.clickLoginButton();
        htMainPage.setTextFiledLogin(login);
        htMainPage.setTextFiledLoginPassword(password);
        htMainPage.clickPopupLoginButton();
    }
}
