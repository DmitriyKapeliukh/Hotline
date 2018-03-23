package com.hotline.tests;

import com.hotline.utilites.DriverFactory;
import com.hotline.utilites.RunContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static com.hotline.utilites.DriverFactory.getWebDriver;

/**
 * Created by Dmytro_Kapeliukh on 4/21/17.
 */
public class BaseTest {

    //private WebDriver driver;

    //private RunContext context = new RunContext();

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        WebDriver driver;
        driver = getWebDriver(DriverFactory.getBrowserTypeByProperty());
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        RunContext.setDriver(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() throws InterruptedException {
        WebDriver driver = RunContext.getDriver();
        driver.quit();
    }
}
