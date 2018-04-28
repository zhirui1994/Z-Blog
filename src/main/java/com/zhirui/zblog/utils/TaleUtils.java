package com.zhirui.zblog.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TaleUtils {

    /**
     * md5加密
     * @param source 数据源
     * @return 加密字符串
     */
    public static String MD5encode(String source) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ignored) {
        }
        byte[] encode = messageDigest.digest(source.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte anEncode : encode) {
            String hex = Integer.toHexString(0xff & anEncode);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
