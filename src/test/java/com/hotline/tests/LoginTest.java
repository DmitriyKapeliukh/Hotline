package com.hotline.tests;

import com.hotline.data.HotlineData;
import com.hotline.pages.HotLineMainPage;
import com.hotline.utilites.RunContext;
import org.testng.annotations.Test;

/**
 * Created by Dmytro_Kapeliukh on 4/17/17.
 */
public class LoginTest extends BaseTest{

    //WebDriver driver = new RunContext().getDriver();


    @Test(groups = "T1", dataProviderClass = HotlineData.class, dataProvider = "login")
    public void loginTest(String login, String password){
        HotLineMainPage htMainPage = new HotLineMainPage(RunContext.getDriver());
        htMainPage.loadPage();
        htMainPage.clickLoginButton();
        htMainPage.setTextFiledLogin(login);
        htMainPage.setTextFiledLoginPassword(password);
        htMainPage.clickSubmitLoginButton();
    }
}
