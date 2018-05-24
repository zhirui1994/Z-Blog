package com.zhirui.zblog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.zhirui.zblog.constant.WebConst;
import com.zhirui.zblog.dto.Types;
import com.zhirui.zblog.model.Vo.ContentVo;
import com.zhirui.zblog.model.Vo.ContentVoExample;
import com.zhirui.zblog.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "admin/page")
public class PageController {
    @Resource
    private ContentService contentService;

    @GetMapping(value = "")
    public String index(HttpServletRequest request) {
        ContentVoExample contentVoExample = new ContentVoExample();
        contentVoExample.setOrderByClause("created desc");
        contentVoExample.createCriteria().andTypeEqualTo(Types.PAGE.getType());
        PageInfo<ContentVo> contentVoPageInfo = contentService.getArticlesWithPage(contentVoExample, 1, WebConst.MAX_POSTS);
        request.setAttribute("articles", contentVoPageInfo);
        return "admin/page_list";
    }
}
