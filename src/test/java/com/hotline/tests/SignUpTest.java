package com.hotline.tests;

import com.hotline.data.HotlineData;
import com.hotline.pages.HotLineEndRegistrationPage;
import com.hotline.pages.HotLineMainPage;
import com.hotline.utilites.RunContext;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Dmytro_Kapeliukh on 4/13/17.
 */
public class SignUpTest extends BaseTest{

    //WebDriver driver = RunContext.getDriver();


    @Test(groups = "T3", dataProviderClass = HotlineData.class, dataProvider = "registration")
    public void signUpTest(String login, String nick, String password){
        HotLineMainPage htMainPage = new HotLineMainPage(RunContext.getDriver());
        htMainPage.loadPage();
        htMainPage.clickLoginButton();
        htMainPage.clickRegistrationButton();
        htMainPage.setTextFieldEmail(login);
        htMainPage.setTextFiledLogin(nick);
        htMainPage.setTextFiledPassword(password);
        htMainPage.clickSubmitButton();
        Assert.assertEquals(RunContext.getDriver().getTitle(), new HotLineEndRegistrationPage(RunContext.getDriver()).getPAGE_TITLE());
    }
}
