package com.hotline.tests;

import com.hotline.HotlineSignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Dmytro_Kapeliukh on 4/13/17.
 */
public class SignUpTest {
    public WebDriver driver;
    HotlineSignUpPage htSignUpPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = new FirefoxDriver();
        htSignUpPage = PageFactory.initElements(driver, HotlineSignUpPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() throws InterruptedException {
        Thread.sleep(6000L);
        this.driver.quit();
    }

    @Test
    public void signUpTest(){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(htSignUpPage.PAGE_URL);
        Assert.assertEquals(driver.getTitle(), htSignUpPage.PAGE_TITLE);
        htSignUpPage.clickRegistrationButton();
        htSignUpPage.setTextFieldEmail("mr.auto.qa@gmail.com");
        htSignUpPage.setTextFiledNick("AutoQA");
        htSignUpPage.settextFieldPassword("mrautoqa12345");
        htSignUpPage.clickSubmitButton();
    }
}
