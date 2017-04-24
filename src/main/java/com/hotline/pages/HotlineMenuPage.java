package com.hotline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = ".//*[@id='card-bookmarks-popup']/div[4]/button[2]")
    WebElement cancelButton;

    @FindBy(css = ".range-price.orng[evcon^='Goprice']")
    WebElement priceList;

    public HotlineMenuPage(WebDriver driver) {
        super(driver);
    }

    public void setTextSearchFiled(String text) {
        setElementText(searchBox, text);
    }

    public void clickSearchButton() {
        clickElement(searchButton);
    }

    public void clickSelectIphone() {
        clickElement(selectIphone);
    }

    public void addElementToTheBookmarks() {
        clickElement(addToBookmarks);
    }

    public void clickSaveBookmarkButton() {
        clickElement(saveBookmark);
    }

    public void clickCancelButton(){
        clickElement(cancelButton);
    }

    public boolean isProductExist(){
        WebElement element = driver.findElement(By.xpath(".//*[@id='card-bookmarks-popup']/form/div[2]"));
        String errorMessage = element.getText();
        if (errorMessage.equals("Товар уже добавлен в этот список")){
            return true;
        }else {
            return false;
        }
    }

    public
}
