package com.hotline.tests;

import com.hotline.HotlineMainPage;
import com.hotline.data.HotlineData;
import org.testng.annotations.Test;

/**
 * Created by Dmytro_Kapeliukh on 4/17/17.
 */
public class LoginTest extends BaseTest{


    @Test(groups = "T1", dataProviderClass = HotlineData.class, dataProvider = "login")
    public void loginTest(String login, String password){
        HotlineMainPage htMainPage = new HotlineMainPage(driver);
        htMainPage.loadPage();
        htMainPage.clickLoginButton();
        htMainPage.setTextFiledLogin(login);
        htMainPage.setTextFiledLoginPassword(password);
        htMainPage.clickPopupLoginButton();
    }
}
