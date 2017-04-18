package com.hotline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Dmytro_Kapeliukh on 4/17/17.
 */
public class HotlineMenuPage extends BasePage {

    @FindBy(css = "#searchbox")
    WebElement searchBox;

    @FindBy(css = "#doSearch")
    WebElement searchButton;

    @FindBy(css = ".m_r-10>[title='Цены на Apple iPhone 7 32GB (Black)']")
    WebElement selectIphone;

    @FindBy(css = ".rel.a-marker.g_statistic")
    WebElement addToBookmarks;

    @FindBy(css = ".but-box.but-blue.m_r-15.m_b-10-330.g_statistic")
    WebElement saveBookmark;

    public HotlineMenuPage(WebDriver driver) {
        super(driver);
    }

    public void setTextSearchFiled(String text){
        setElementText(searchBox, text);
    }

    public void clickSearchButton(){
        clickElement(searchButton);
    }

    public void clickSelectIphone(){
        clickElement(selectIphone);
    }

    public void addElementToTheBookmarks(){
        clickElement(addToBookmarks);
    }

    public void clickSaveBookmarkButton(){
        clickElement(saveBookmark);
    }
}
