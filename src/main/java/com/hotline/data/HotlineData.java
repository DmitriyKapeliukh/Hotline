package com.hotline.data;

import org.testng.annotations.DataProvider;

/**
 * Created by Dmytro_Kapeliukh on 4/13/17.
 */
public class HotlineData {
    @DataProvider(name = "login")
    public static Object[][] login(){
        return new Object[][]{
                {"mr.auto.qa@gmail.com", "mrautoqa12345"}
        };
    }
}
