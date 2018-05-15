package com.zhirui.zblog.intercepter;

import com.zhirui.zblog.constant.WebConst;
import com.zhirui.zblog.dto.Types;
import com.zhirui.zblog.model.Vo.UserVo;
import com.zhirui.zblog.service.UserService;
import com.zhirui.zblog.utils.Commons;
import com.zhirui.zblog.utils.MapCache;
import com.zhirui.zblog.utils.TaleUtils;
import com.zhirui.zblog.utils.UUID;
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

    private MapCache cache = MapCache.single();

    @Resource
    private UserService userService;

    @Resource
    private Commons commons;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        UserVo user = TaleUtils.getLoginUser(request);
        if (user == null) {
            Integer uid = TaleUtils.getCookieUid(request);
            if (uid != null) {
                userService.queryUserById(uid);
                user = userService.queryUserById(uid);
                request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
            }
        }

        // spring boot 2.0 拦截掉静态资源请求，这里手动通过这些文件请求
        if(uri.endsWith(".js") || uri.endsWith(".css") || uri.endsWith(".jpg") || uri.endsWith(".png")) {
            return true;
        }

        if (uri.startsWith("/admin") && !uri.startsWith("/admin/login") && user == null) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }

        if (request.getMethod().equals("GET")) {
            String csrf_token = UUID.UU64();
            cache.hset(Types.CSRF_TOKEN.getType(), csrf_token, uri, 30 * 60);
            request.setAttribute("_csrf_token", csrf_token);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        request.setAttribute("commons", commons);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
