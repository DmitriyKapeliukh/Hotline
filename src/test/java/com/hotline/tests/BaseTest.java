package com.hotline.tests;

import com.hotline.utilites.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static com.hotline.utilites.DriverFactory.getWebDriver;

/**
 * Created by Dmytro_Kapeliukh on 4/21/17.
 */
public class BaseTest {

    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = getWebDriver(DriverFactory.getBrowserTypeByProperty());
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() throws InterruptedException {
        driver.quit();
    }
}
