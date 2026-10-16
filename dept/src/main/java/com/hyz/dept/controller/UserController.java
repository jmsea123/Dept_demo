package com.hyz.dept.controller;

import com.hyz.dept.common.R;
import com.hyz.dept.entity.User;
import com.hyz.dept.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R<User> login(@RequestBody User user, HttpSession session) {
        User dbUser = userService.login(user.getUsername(), user.getPassword());
        dbUser.setPassword(null);                 // 不回传密码
        session.setAttribute("loginUser", dbUser);
        return R.success(dbUser, "登录成功");
    }
    @PostMapping("/register")
    public R<Void> register(@RequestBody User user) {
        userService.register(user);
        return R.successMsg("注册成功");
    }
    @PostMapping("/logout")
    public R<Void> logout(HttpSession session) {
        session.invalidate();
        return R.successMsg("退出成功");
    }
}
