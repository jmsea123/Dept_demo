package com.hyz.dept.service.impl;

import com.hyz.dept.entity.User;
import com.hyz.dept.mapper.UserMapper;
import com.hyz.dept.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        User dbUser = userMapper.selectByUsername(username);
        if (dbUser == null) throw new RuntimeException("用户名不存在");
        String md5 = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        if (!md5.equalsIgnoreCase(dbUser.getPassword())) throw new RuntimeException("密码错误");
        return dbUser;
    }

    @Override
    public void register(User user) {
        if (userMapper.selectByUsername(user.getUsername()) != null) {
            throw new RuntimeException("用户名已存在");
        }
        user.setPassword(DigestUtils.md5DigestAsHex(
                user.getPassword().getBytes(StandardCharsets.UTF_8)));
        userMapper.insert(user);
    }
}
