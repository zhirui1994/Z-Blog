package com.zhirui.zblog.controller;

import com.zhirui.zblog.constant.WebConst;
import com.zhirui.zblog.model.Bo.ArchiveBo;
import com.zhirui.zblog.model.Vo.CommentVo;
import com.zhirui.zblog.model.Vo.ContentVo;
import com.zhirui.zblog.service.CommentServiceImpl;
import com.zhirui.zblog.service.ContentService;
import com.zhirui.zblog.service.SiteService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller("IndexController")
public class IndexController extends BaseController {

    @Resource
    private ContentService contentService;

    @Resource
    private CommentServiceImpl commentService;

    @Resource
    private SiteService siteService;

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

    @RequestMapping(value = "articles/{cid}", method = RequestMethod.GET)
    public String getArticle(HttpServletRequest request, @PathVariable String cid) {
        ContentVo content = contentService.getContent(cid);
        if (content == null || "draft".equals(content.getStatus())) {
            return this.render_404();
        }
        request.setAttribute("article", content);
        request.setAttribute("is_post", true);
        completeArticle(request, content);
        return this.render("post");
    }

    private void completeArticle(HttpServletRequest request, ContentVo content) {
        if (content.getAllowComment()) {
            String cp = request.getParameter("cp");
            if (StringUtils.isEmpty(cp)) {
                cp = "1";
            }
            request.setAttribute("cp", cp);
            List<CommentVo> commentsPaginator = commentService.getComments(content.getCid(), Integer.parseInt(cp), 6);
            request.setAttribute("comments", commentsPaginator);
        }
    }

    public String archives(HttpServletRequest request) {
        List<ArchiveBo> archives = siteService.getArchives();
        request.setAttribute("archives", archives);
        return this.render("archives");
    }
}
