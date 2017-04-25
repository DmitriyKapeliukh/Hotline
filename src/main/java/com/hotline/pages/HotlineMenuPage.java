package com.hotline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.valueOf;

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

    @FindBy(css = ".m_b-15")
    List<WebElement> blocks;

    @FindBy(css = ".range-price.orng[evcon^='Goprice']")
    List<WebElement> priceList2;

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

    public void clickCancelButton() {
        clickElement(cancelButton);
    }

    public boolean isProductExist() {
        WebElement element = driver.findElement(By.xpath(".//*[@id='card-bookmarks-popup']/form/div[2]"));
        String errorMessage = element.getText();
        if (errorMessage.equals("Товар уже добавлен в этот список")) {
            return true;
        } else {
            return false;
        }
    }

    public int tablePrice() {
        List<Integer> prices = new ArrayList<Integer>();
        List<WebElement> list = driver.findElements(By.cssSelector(".range-price.orng[evcon^='Goprice']"));
        Iterator<WebElement> itr = list.iterator();
        while (itr.hasNext()) {
            String priceValue = itr.next().getText().replaceAll("[^\\d]", "");
            prices.add(valueOf(priceValue));
        }
        int min = prices.get(0);
        for (int i : prices){
            min = min < i ? min : i;
        }
        System.out.println(min);
        return min;
    }

    public List<Integer>getPrices(){
        return blocks.stream()
                .map(element -> element.findElement(By.xpath("//*[contains(@class, 'range-price orng')]"))
                        .getText().replaceAll("[^\\d]", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<String>getPrices2(){
        List<String> list = new ArrayList<>();
        priceList2.stream().map(WebElement::getText).forEach(list::add);
        return list;
    }

    public static void main(String[] args) {
        List<WebElement> elements = new ArrayList<>();

        boolean isMin = false;

        List<Integer> prices = elements.stream()
                .map(WebElement::getText)
                .map(CorporateGroupManagementPage::parsePrice)
                .collect(Collectors.toList());

        Collections.sort(prices);
        int min = prices.get(isMin ? 0 : prices.size() - 1);

        elements.stream().filter(element -> parsePrice(element.getText()) == min)
                .findFirst()
                .get()
                .click();
    }

    private static int parsePrice(final String priceValue) {
        return Integer.parseInt(priceValue.replaceAll("\\D", ""));
    }
}
