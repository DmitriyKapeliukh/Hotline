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

    }

    @AfterClass(alwaysRun = true)
    public void theardown() throws InterruptedException {
        Thread.sleep(3000L);
        driver.quit();
    }

    @Test(groups = "T2", dataProviderClass = HotlineData.class, dataProvider = "login")
    public void selectIphone(String email, String password) throws InterruptedException {
        htMainPage.loadPage();
        htMainPage.login(email, password);
        htMenuPage.setTextSearchFiled("Iphone");
        htMenuPage.clickSearchButton();
        htMenuPage.clickSelectIphone();
        htMenuPage.addElementToTheBookmarks();
        htMenuPage.clickSaveBookmarkButton();
        if (htMenuPage.isProductExist()){
            htMenuPage.clickCancelButton();
            System.out.println("Product already exist");
        }

        //System.out.println(FFtest.fluentWaitForElementAndGetTextFromIt(By.xpath(".//*[@id='card-bookmarks-popup']/form/div[2]"), 10));

    }
}
