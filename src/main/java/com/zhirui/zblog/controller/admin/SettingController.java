package com.zhirui.zblog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "admin/setting")
public class SettingController {
    @GetMapping(value = "")
    public String index(HttpServletRequest request) {
        Map<String, String> options = new HashMap<>();
        request.setAttribute("options", options);
        return "admin/setting";
    }
}
