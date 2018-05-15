package com.zhirui.zblog.controller.admin;

import com.zhirui.zblog.constant.WebConst;
import com.zhirui.zblog.model.Bo.ResetResponseBo;
import com.zhirui.zblog.model.Vo.UserVo;
import com.zhirui.zblog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin")
public class AuthController {

    @Resource
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return  "admin/login";
    }

    @PostMapping(value = "login")
    @ResponseBody
    public ResetResponseBo doLogin(@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam(required = false) String remeber_me,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {

        UserVo user = userService.login(username, password);
        request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
        return ResetResponseBo.ok();
    }
}
