package com.hyz.dept.interceptor;

import com.hyz.dept.common.R;
import com.hyz.dept.common.ResultEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import tools.jackson.databind.ObjectMapper;

public class LoginInterceptor implements HandlerInterceptor {
    private final ObjectMapper om = new ObjectMapper();
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
            throws Exception {
        if (req.getSession().getAttribute("loginUser") != null) return true;
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(om.writeValueAsString(
                R.ofEnum(ResultEnum.UNAUTH, null)));
        return false;
    }
}
