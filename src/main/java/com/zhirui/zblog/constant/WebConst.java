package com.zhirui.zblog.constant;

import org.springframework.stereotype.Component;

@Component
public class WebConst {
    public static String LOGIN_SESSION_KEY = "login_user";
    public static String USER_IN_COOKIE = "S_L_ID";
    /**
     * aes加密加盐
     */
    public static String AES_SALT = "0123456789abcdef";

    /**
     * 最大页码
     */
    public static final int MAX_PAGE = 100;
}
