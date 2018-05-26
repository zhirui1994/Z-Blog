package com.zhirui.zblog.controller.admin;

import com.zhirui.zblog.constant.WebConst;
import com.zhirui.zblog.dto.Types;
import com.zhirui.zblog.utils.Commons;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "admin/attach")
public class AttachController {
    @GetMapping(value = "")
    public String index(HttpServletRequest request) {
        request.setAttribute("attachs", null);
        request.setAttribute(Types.ATTACH_URL.getType(), Commons.site_option(Types.ATTACH_URL.getType(), Commons.site_url()));
        request.setAttribute("max_file_size", WebConst.MAX_FILE_SIZE / 1024);
        return "admin/attach";
    }
}
