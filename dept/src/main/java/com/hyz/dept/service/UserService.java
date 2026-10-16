package com.hyz.dept.service;

import com.hyz.dept.entity.User;

public interface UserService {
    //登录
    User login(String username, String password);
    //注册
    void register(User user);
}
