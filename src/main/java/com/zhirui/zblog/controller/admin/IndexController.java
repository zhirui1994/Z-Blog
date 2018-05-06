package com.zhirui.zblog.controller.admin;

import com.zhirui.zblog.controller.BaseController;
import com.zhirui.zblog.model.Bo.ResetResponseBo;
import com.zhirui.zblog.model.Bo.StatisticsBo;
import com.zhirui.zblog.model.Vo.CommentVo;
import com.zhirui.zblog.model.Vo.ContentVo;
import com.zhirui.zblog.model.Vo.LogVo;
import com.zhirui.zblog.model.Vo.UserVo;
import com.zhirui.zblog.service.impl.LogServiceImpl;
import com.zhirui.zblog.service.impl.SiteServiceImpl;
import com.zhirui.zblog.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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

    @Resource
    private LogServiceImpl logService;

    @GetMapping(value = {"admin", "admin/index"})
    public String index(HttpServletRequest request) {
        List<CommentVo> comments = siteService.recentComments(10);
        List<ContentVo> contents = siteService.recentContents(10);
        StatisticsBo statistics = siteService.getStatistcs();
        List<LogVo> logs = logService.getLogs(0, 10);

        request.setAttribute("comments", comments);
        request.setAttribute("articles", contents);
        request.setAttribute("statistics", statistics);
        request.setAttribute("logs", logs);
        return "admin/index";
    }

    @GetMapping(value = "logs")
    @ResponseBody
    public ResetResponseBo<ArrayList<LogVo>> getLogs(@RequestParam int page, @RequestParam int limit) {
        List<LogVo> logs = logService.getLogs(page, limit);
        return ResetResponseBo.ok(logs);
    }

    @GetMapping(value = "comments")
    @ResponseBody
    public ResetResponseBo<ArrayList<CommentVo>> getCommentsByPage(@RequestParam int limit) {
        List<CommentVo> comments = siteService.recentComments(limit);
        return ResetResponseBo.ok(comments);
    }

    @GetMapping(value = "statistics")
    @ResponseBody
    public ResetResponseBo getStatistics() {
        StatisticsBo statistics = siteService.getStatistcs();
        return ResetResponseBo.ok(statistics);
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
