package com.zhirui.zblog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "admin/links")
public class LinksController {
    @GetMapping(value = "")
    public String index(HttpServletRequest request) {
        request.setAttribute("links", null);
        return "admin/links";
    }
}
