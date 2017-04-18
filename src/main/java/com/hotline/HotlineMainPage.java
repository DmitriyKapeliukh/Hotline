package com.hotline;

import com.hotline.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Created by Dmytro_Kapeliukh on 4/13/17.
 */
public class HotlineMainPage extends BasePage{

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

    @FindBy(css = ".open-lightbox>b")
    WebElement loginButton;

    @FindBy(name = "login")
    WebElement fieldLogin;

    @FindBy(name = "password")
    WebElement filedLoginPassword;

    @FindBy(css = ".cell.but-box.but-blue")
    WebElement PopupLoginButton;

    @FindBy(css = "#open-user-menu.user.no-adapt-lg>span")
    WebElement userTitle;

    @FindBy(css = ".close-x")
    WebElement crossTick;

    public HotlineMainPage(WebDriver driver){
        super(driver);
        this.PAGE_TITLE = "Hotline - сравнить цены в интернет-магазинах Украины";
        this.PAGE_URL = "http://hotline.ua/";
    }

    public void login(String email, String password){
        clickElement(loginButton);
        setTextFiledLogin(email);
        setTextFiledLoginPassword(password);
        clickPopupLoginButton();
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

    public void clickPopupLoginButton(){
        clickElement(PopupLoginButton);
    }

    public void clickCrossTick(){
        clickElement(crossTick);
    }

    public String getUserTitle(){
        wait.until(ExpectedConditions.elementToBeClickable(userTitle));
        return userTitle.getText();
    }
}
