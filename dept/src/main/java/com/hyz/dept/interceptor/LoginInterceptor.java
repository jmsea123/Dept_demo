package com.hyz.dept.interceptor;

import com.hyz.dept.common.R;
import com.hyz.dept.common.ResultEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import tools.jackson.databind.ObjectMapper;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    // Jackson序列化工具，把R对象转为JSON字符串返回前端
    private final ObjectMapper om = new ObjectMapper();
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
            throws Exception {
        // req.getSession(false)：获取session，如果不存在，不新建session，直接返回null
        HttpSession session = req.getSession(false);
        // 判断：session不为空，并且session里面存了loginUser登录对象 → 已登录
        if (session != null && session.getAttribute("loginUser") != null) {
            return true;   // 已登录，放行
        }
        // 走到这里代表未登录，直接返回统一R对象（未授权）
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(om.writeValueAsString(
                R.ofEnum(ResultEnum.UNAUTH, null)));
        return false;// false = 拦截，不再向后执行，不会走到Controller
    }
}
