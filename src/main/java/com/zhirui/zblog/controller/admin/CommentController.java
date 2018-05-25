package com.zhirui.zblog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.zhirui.zblog.controller.BaseController;
import com.zhirui.zblog.model.Vo.CommentVo;
import com.zhirui.zblog.model.Vo.CommentVoExample;
import com.zhirui.zblog.model.Vo.UserVo;
import com.zhirui.zblog.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "admin/comments")
public class CommentController extends BaseController {
    @Resource
    private CommentService commentService;

    @GetMapping(value = "")
    public String index(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "15") int limit,
            HttpServletRequest request
    ) {
        UserVo user = this.user(request);
        CommentVoExample commentVoExample = new CommentVoExample();
        commentVoExample.setOrderByClause("coid desc");
//        commentVoExample.createCriteria()
        PageInfo<CommentVo> commentVoPageInfo = commentService.getCommentsWithPage(commentVoExample, page, limit);
        request.setAttribute("comments", commentVoPageInfo);
        return "admin/comment_list";
    }
}
