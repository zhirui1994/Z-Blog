package com.zhirui.zblog.controller;

import com.zhirui.zblog.model.Vo.UserVo;
import com.zhirui.zblog.utils.TaleUtils;

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

    public String render_404() {
        return "comm/error_404";
    }

    public UserVo user(HttpServletRequest request) {
        return TaleUtils.getLoginUser(request);
    }
}
