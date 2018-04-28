package com.zhirui.zblog.controller.admin;

import com.zhirui.zblog.model.Bo.ResetResponseBo;
import com.zhirui.zblog.model.Vo.UserVo;
import com.zhirui.zblog.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller("adminIndexController")
@RequestMapping("/")
public class IndexController {
    @Resource
    private UserServiceImpl userService;

    @GetMapping(value = "user")
    @ResponseBody
    public ResetResponseBo getUser(@RequestParam Integer uid) {
        UserVo user = userService.queryUserById(uid);
        return ResetResponseBo.ok(user);
    }
}
