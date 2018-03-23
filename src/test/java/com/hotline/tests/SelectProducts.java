package com.hotline.tests;

import com.hotline.data.HotlineData;
import com.hotline.pages.HotLineMainPage;
import com.hotline.pages.HotLineMenuPage;
import com.hotline.utilites.RunContext;
import org.testng.annotations.Test;

/**
 * Created by Dmytro_Kapeliukh on 4/17/17.
 */
public class SelectProducts extends BaseTest{

    //WebDriver driver = new RunContext().getDriver();

    //private HotLineMenuPage htMenuPage;
    //private HotLineMainPage htMainPage;

    @Test(groups = "T2", dataProviderClass = HotlineData.class, dataProvider = "login")
    public void selectIphone(String email, String password) throws InterruptedException {
        HotLineMainPage htMainPage = new HotLineMainPage(RunContext.getDriver());
        HotLineMenuPage htMenuPage = new HotLineMenuPage(RunContext.getDriver());
        htMainPage.loadPage();
        htMainPage.login(email, password);
        htMenuPage.setTextSearchFiled("Iphone");
        htMenuPage.clickSearchButton();
        htMenuPage.clickSelectIphone();
        htMenuPage.addElementToTheBookmarks();
        htMenuPage.clickSaveBookmarkButton();
        if (htMenuPage.isProductExist()) {
            htMenuPage.clickCancelButton();
            System.out.println("Product already exist");
        }
    }

    @Test(groups = "T2", dataProviderClass = HotlineData.class, dataProvider = "login")
    public void selectChipperIphone(String email, String password) throws InterruptedException {
        HotLineMainPage htMainPage = new HotLineMainPage(RunContext.getDriver());
        HotLineMenuPage htMenuPage = new HotLineMenuPage(RunContext.getDriver());
        htMainPage.loadPage();
        htMainPage.login(email, password);
        htMenuPage.setTextSearchFiled("Iphone");
        htMenuPage.clickSearchButton();
        htMenuPage.clickSelectIphone();
        htMenuPage.selectIphone();
    }
}
