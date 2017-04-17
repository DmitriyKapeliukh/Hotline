package com.hotline.tests;

import com.hotline.HotlineMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Dmytro_Kapeliukh on 4/13/17.
 */
public class SignUpTest {
    public WebDriver driver;
    HotlineMainPage htMainPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = new FirefoxDriver();
        htMainPage = PageFactory.initElements(driver, HotlineMainPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() throws InterruptedException {
        Thread.sleep(6000L);
        this.driver.quit();
    }

    @Test
    public void signUpTest(){
        htMainPage.loadPage();
        htMainPage.clickRegistrationButton();
        htMainPage.setTextFieldEmail("mr.auto.qa@gmail.com");
        htMainPage.setTextFiledNick("AutoQA");
        htMainPage.setTextFiledPassword("mrautoqa12345");
        htMainPage.clickSubmitButton();
    }
}
