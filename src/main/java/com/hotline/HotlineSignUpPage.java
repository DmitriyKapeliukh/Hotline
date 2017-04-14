package com.hotline;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by Dmytro_Kapeliukh on 4/13/17.
 */
public class HotlineSignUpPage {
    public static final String PAGE_TITLE = "Hotline - сравнить цены в интернет-магазинах Украины";
    public static final String PAGE_URL = "http://hotline.ua/";

    WebDriver driver;

    @FindBy(css = ".reg")
    WebElement registrationButton;

    @FindBy(name = "email")
    WebElement fieldEmail;

    @FindBy(name = "nick")
    WebElement fieldNick;

    @FindBy(name = "password")
    WebElement fieldPassword;

    @FindBy(id = "submit-button")
    WebElement submitButton;

    public HotlineSignUpPage(){
        this.driver = driver;
    }

    public void setTextFieldEmail(String text){
        fieldEmail.sendKeys(text);
        Assert.assertEquals(fieldEmail.getAttribute("value"), text);
    }

    public void setTextFiledNick(String text){
        fieldNick.clear();
        fieldNick.sendKeys(text);
        Assert.assertEquals(fieldNick.getAttribute("value"), text);
    }

    public void settextFieldPassword(String text){
        fieldPassword.sendKeys(text);
        Assert.assertEquals(fieldPassword.getAttribute("value"), text);
    }

    public void clickRegistrationButton(){
        registrationButton.click();
    }

    public void clickSubmitButton(){
        submitButton.click();
    }
}
