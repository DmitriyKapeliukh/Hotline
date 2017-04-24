package com.hotline.data;

import org.testng.annotations.DataProvider;

/**
 * Created by Dmytro_Kapeliukh on 4/13/17.
 */
public class HotlineData {
    static RandomGenerator randomGenerator;

    @DataProvider(name = "login")
    public static Object[][] login(){
        return new Object[][]{
                {"mr.auto.qa@gmail.com", "mrautoqa12345"},
        };
    }

    @DataProvider(name = "registration")
    public static Object[][] registration(){
        randomGenerator = new RandomGenerator();
        return new Object[][]{
                {randomGenerator.getLogin(), randomGenerator.getNick(), randomGenerator.getPassword()},
                {"adada", "adads", "adada"},
                {"adada", "adads", "adada"},
                {"adada", "adads", "adada"},
                {"adada", "adads", "adada"},
                {"adada", "adads", "adada"},
        };
    }
}
