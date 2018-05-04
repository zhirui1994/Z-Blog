package com.zhirui.zblog.controller.admin;

import com.zhirui.zblog.controller.BaseController;
import com.zhirui.zblog.model.Bo.ResetResponseBo;
import com.zhirui.zblog.model.Vo.CommentVo;
import com.zhirui.zblog.model.Vo.ContentVo;
import com.zhirui.zblog.model.Vo.UserVo;
import com.zhirui.zblog.service.impl.SiteServiceImpl;
import com.zhirui.zblog.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller("adminIndexController")
@RequestMapping("/")
public class IndexController extends BaseController {
    @Resource
    private UserServiceImpl userService;

    @Resource
    private SiteServiceImpl siteService;

    @GetMapping(value = {"admin", "admin/index"})
    public String index(HttpServletRequest request) {
        List<CommentVo> comments = siteService.recentComments(10);
        return "admin/index";
    }

    @GetMapping(value = "comments")
    @ResponseBody
    public ResetResponseBo<ArrayList<CommentVo>> getCommentsByPage(@RequestParam int limit) {
        List<CommentVo> comments = siteService.recentComments(limit);
        return ResetResponseBo.ok(comments);
    }

    @GetMapping(value = "content")
    @ResponseBody
    public ResetResponseBo<ArrayList> getContentsByPage(@RequestParam int limit) {
        List<ContentVo> contents = siteService.recentContents(limit);
        return ResetResponseBo.ok(contents);
    }

    @GetMapping(value = "user")
    @ResponseBody
    public ResetResponseBo getUser(@RequestParam Integer uid) {
        UserVo user = userService.queryUserById(uid);
        return ResetResponseBo.ok(user);
    }
}
