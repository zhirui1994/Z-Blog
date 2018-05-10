package com.zhirui.zblog.controller;

import com.zhirui.zblog.constant.WebConst;
import com.zhirui.zblog.model.Vo.ContentVo;
import com.zhirui.zblog.service.impl.ContentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@Controller("IndexController")
public class IndexController extends BaseController {

    @Resource
    private ContentServiceImpl contentService;

    @GetMapping(value = "/")
    public String index(HttpServletRequest request, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        return this.index(request, 1, limit);
    }

    @GetMapping(value = "page/{p}")
    public String index(HttpServletRequest request, @PathVariable int p, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        p = p < 0 || p > WebConst.MAX_PAGE ? 1 : p;
        ArrayList<ContentVo> contents = (ArrayList<ContentVo>) contentService.getContents(p, limit);
        request.setAttribute("articles", contents);
        return this.render("index");
    }
}
