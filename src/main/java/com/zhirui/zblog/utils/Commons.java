package com.zhirui.zblog.utils;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public final class Commons {
    public static  String THEME = "themes/default";

    public static String gravatar(String email) {
        String avatarUrl = "https://github.com/identicons/";
        if (StringUtils.isEmpty(email)) {
            email = "user@hanshuai.xin";
        }
        String hash = TaleUtils.MD5encode(email.trim().toLowerCase());
        return avatarUrl + hash + ".png";
    }

    public static String random(int max, String str) {
        return UUID.random(1, max) + str;
    }
}
