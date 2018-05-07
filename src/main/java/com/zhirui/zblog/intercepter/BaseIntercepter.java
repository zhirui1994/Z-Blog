package com.zhirui.zblog.intercepter;

import com.zhirui.zblog.model.Vo.UserVo;
import com.zhirui.zblog.service.impl.UserServiceImpl;
import com.zhirui.zblog.utils.TaleUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器，验证session等
 */
@Component
public class BaseIntercepter implements HandlerInterceptor {

    @Resource
    private UserServiceImpl userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserVo user = TaleUtils.getLoginUser(request);
        if (user == null) {
            int uid = TaleUtils.getCookieUid(request);
            if (uid) {
                userService.queryUserById(uid);
                user = userService.queryUserById(uid);
                request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
