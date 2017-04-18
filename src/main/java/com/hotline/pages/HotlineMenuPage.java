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

    public HotlineMenuPage(WebDriver driver) {
        super(driver);
    }

    public void setTextSearchFiled(String text){
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        setElementText(searchBox, text);
    }

    public void clickSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));

        clickElement(searchButton);
    }

    public void clickSelectIphone(){
        clickElement(selectIphone);
    }
}
