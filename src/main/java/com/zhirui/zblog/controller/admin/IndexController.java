package com.zhirui.zblog.controller.admin;

import com.zhirui.zblog.controller.BaseController;
import com.zhirui.zblog.model.Bo.ResetResponseBo;
import com.zhirui.zblog.model.Vo.UserVo;
import com.zhirui.zblog.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller("adminIndexController")
@RequestMapping("/")
public class IndexController extends BaseController {
    @Resource
    private UserServiceImpl userService;

    @GetMapping(value = {"admin", "admin/index"})
    public String index(HttpServletRequest request) {

        return "admin/index";
    }

    @GetMapping(value = "user")
    @ResponseBody
    public ResetResponseBo getUser(@RequestParam Integer uid) {
        UserVo user = userService.queryUserById(uid);
        return ResetResponseBo.ok(user);
    }
}
