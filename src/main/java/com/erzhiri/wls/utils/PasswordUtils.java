package com.erzhiri.wls.utils;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author erzhiri
 * @version 0.1.0
 * @since 0.1.0
 **/
public class PasswordUtils {
    public static String encode(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
    }
}
