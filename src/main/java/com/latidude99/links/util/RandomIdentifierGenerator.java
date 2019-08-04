package com.latidude99.links.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class RandomIdentifierGenerator {

    static final String CHAR_POOL = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom secureRandom = new SecureRandom();

    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(CHAR_POOL.charAt(secureRandom.nextInt(CHAR_POOL.length())));
        return sb.toString();
    }

    public String randomPin(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(CHAR_POOL.charAt(secureRandom.nextInt(CHAR_POOL.length())));
        return sb.toString();
    }
}
