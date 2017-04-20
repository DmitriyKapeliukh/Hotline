package com.hotline.data;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by Dmytro_Kapeliukh on 4/19/17.
 */
public class RandomGenerator {private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String login = generateRandom(15)+"@gmail.com";
    private String nick = generateRandom(15);
    private String password = generateRandom(15);


    public static String generateRandom(int length) {
        Random random = new SecureRandom();
        if (length <= 0) {
            throw new IllegalArgumentException("String length must be a positive integer");
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString().toLowerCase();
    }

    public String getLogin(){
        return login;
    }

    public String getNick(){
        return nick;
    }
    public String getPassword(){
        return password;
    }
}
