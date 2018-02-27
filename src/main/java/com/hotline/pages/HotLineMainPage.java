package com.hotline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Created by Dmytro_Kapeliukh on 4/13/17.
 */
public class HotLineMainPage extends BasePage{

    @FindBy(xpath = "//*[@class = 'text']//*[@href = '/register/']")
    private WebElement registrationButton;

    @FindBy(name = "email")
    private WebElement fieldEmail;

    @FindBy(name = "nick")
    private WebElement fieldNick;

    @FindBy(name = "password")
    private WebElement fieldPassword;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(css = ".item-login .name")
    private WebElement loginButton;

    @FindBy(name = "login")
    private WebElement fieldLogin;

    @FindBy(name = "password")
    private WebElement filedLoginPassword;

    @FindBy(css = "[type=submit]")
    private WebElement submitLogin;

    @FindBy(css = "#open-user-menu.user.no-adapt-lg>span")
    private WebElement userTitle;

    @FindBy(css = ".close-x")
    WebElement crossTick;

    public HotLineMainPage(WebDriver driver){
        super(driver);
        this.PAGE_TITLE = "Hotline - сравнить цены в интернет-магазинах Украины";
        this.PAGE_URL = "http://hotline.ua/";
    }

    public void login(String email, String password){
        clickElement(loginButton);
        setTextFiledLogin(email);
        setTextFiledLoginPassword(password);
        clickSubmitLoginButton();
        clickCrossTick();
        Assert.assertEquals(getUserTitle(), "AutoQA");
    }

    public void setTextFieldEmail(String text){
      setElementText(fieldEmail, text);
    }

    public void setTextFiledNick(String text){
        setElementText(fieldNick, text);
    }

    public void setTextFiledPassword(String text){
        setElementText(fieldPassword, text);
    }

    public void clickRegistrationButton(){
        clickElement(registrationButton);
    }

    public void clickSubmitButton(){
        clickElement(submitButton);
    }

    public void clickLoginButton(){
        clickElement(loginButton);
    }

    public void setTextFiledLogin(String text){
        setElementText(fieldLogin, text);
    }

    public void setTextFiledLoginPassword(String text){
        setElementText(filedLoginPassword, text);
    }

    public void clickSubmitLoginButton(){
        clickElement(submitLogin);
    }

    public void clickCrossTick(){
        clickElement(crossTick);
    }

    public String getUserTitle(){
        wait.until(ExpectedConditions.elementToBeClickable(userTitle));
        return userTitle.getText();
    }
}
