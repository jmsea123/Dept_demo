package com.hyz.dept.interceptor;

import com.hyz.dept.common.R;
import com.hyz.dept.common.ResultEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import tools.jackson.databind.ObjectMapper;

public class LoginInterceptor implements HandlerInterceptor {
    private final ObjectMapper om = new ObjectMapper();
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
            throws Exception {
        // false = 不存在就返回 null，不创建
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("loginUser") != null) {
            return true;   // 已登录，放行
        }
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(om.writeValueAsString(
                R.ofEnum(ResultEnum.UNAUTH, null)));
        return false;
    }
}
