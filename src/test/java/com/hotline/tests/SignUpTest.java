package com.hotline.tests;

import com.hotline.HotlineMainPage;
import com.hotline.data.HotlineData;
import com.hotline.pages.HotlineEndRegistrationPage;
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
    HotlineMainPage htMainPage;
    HotlineEndRegistrationPage htEndRegistrationPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = new FirefoxDriver();
        htMainPage = PageFactory.initElements(driver, HotlineMainPage.class);
        htEndRegistrationPage = PageFactory.initElements(driver, HotlineEndRegistrationPage.class);

    }

    @AfterClass(alwaysRun = true)
    public void teardown() throws InterruptedException {
        Thread.sleep(6000L);
        this.driver.quit();
    }


    @Test(groups = "T3", dataProviderClass = HotlineData.class, dataProvider = "registration")
    public void signUpTest(String login, String nick, String password){
        htMainPage.loadPage();
        htMainPage.clickRegistrationButton();
        htMainPage.setTextFieldEmail(login);
        htMainPage.setTextFiledNick(nick);
        htMainPage.setTextFiledPassword(password);
        htMainPage.clickSubmitButton();
        Assert.assertEquals(driver.getTitle(), htEndRegistrationPage.getPAGE_TITLE());
    }
}
