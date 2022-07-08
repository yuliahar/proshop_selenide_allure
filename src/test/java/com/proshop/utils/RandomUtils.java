package com.proshop.utils;

import java.sql.Timestamp;
import java.util.Random;

public class RandomUtils {

    private String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String lowerChars = "abcdefghijklmnopqrstuvwxyz";
    private static String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String numbers = "0123456789";
    private static String specialChars = "!@#$%^&*";
    public static String getRandomString(int len, String str) {
        StringBuilder result = new StringBuilder(len);
        Random rnd = new Random();
        for(int i = 0; i < len; i++)
            result.append(str.charAt(rnd.nextInt(str.length())));
        return result.toString();
    }

    public static String getRandomPassword(int length, Boolean hasNumbers, Boolean hasSymbols) {
        String password = "";

        if (hasNumbers) {
            password += getRandomString((int) Math.round(length / 4), numbers);
        }

        if (hasSymbols) {
            password += getRandomString((int) Math.round(length / 4), specialChars);
        }

        password += getRandomString((int) Math.round(length / 4), upperChars);
        password += getRandomString(length - 3 * (int) Math.round(length / 4), lowerChars);
        return  password;
    }
}
