package com.zhirui.zblog.controller;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    public static String THEME = "themes/default";

    public String render(String viewName) {
        return THEME + "/" + viewName;
    }

    public BaseController title(HttpServletRequest request, String title) {
        request.setAttribute("title", title);
        return this;
    }

    public BaseController keywords(HttpServletRequest request, String keywords) {
        request.setAttribute("keywords", keywords);
        return this;
    }
}