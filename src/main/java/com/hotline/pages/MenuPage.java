package com.hotline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dmytro_Kapeliukh on 4/17/17.
 */
public class MenuPage extends BasePage {

    @FindBy(css = "#searchbox")
    WebElement searchBox;

    @FindBy(css = "#doSearch")
    WebElement searchButton;

    @FindBy(css = ".m_r-10>[title='Цены на Apple iPhone 7 32GB (Black)']")
    WebElement selectIphone;

    public MenuPage(WebDriver driver) {
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
}
