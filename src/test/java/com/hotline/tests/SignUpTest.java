package com.hotline.tests;

import com.hotline.data.HotlineData;
import com.hotline.pages.HotLineMainPage;
import com.hotline.pages.HotlineEndRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Dmytro_Kapeliukh on 4/13/17.
 */
public class SignUpTest extends BaseTest{


    @Test(groups = "T3", dataProviderClass = HotlineData.class, dataProvider = "registration")
    public void signUpTest(String login, String nick, String password){
        HotLineMainPage htMainPage = new HotLineMainPage(driver);
        htMainPage.loadPage();
        htMainPage.clickLoginButton();
        htMainPage.clickRegistrationButton();
        htMainPage.setTextFieldEmail(login);
        htMainPage.setTextFiledLogin(nick);
        htMainPage.setTextFiledPassword(password);
        htMainPage.clickSubmitButton();
        Assert.assertEquals(driver.getTitle(), new HotlineEndRegistrationPage(driver).getPAGE_TITLE());
    }
}
