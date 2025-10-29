package com.pn.service.impl;

import com.pn.entity.User;
import com.pn.mapper.UserMapper;
import com.pn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User studentLogin(String username, String password) {
        if(!StringUtils.hasText(username)){
            throw new RuntimeException("学号不能为空！");
        }
        if(!StringUtils.hasText(password)){
            throw new RuntimeException("密码不能为空！");
        }

        User user = userMapper.findUserByUsername(username);
        if(user == null){
            throw new RuntimeException("学号不存在！");
        }

        if(!password.equals(user.getPassword())){
            throw new RuntimeException("密码错误！");
        }

        userMapper.updateLastLoginTime(user.getId().intValue());
        user.setPassword(null);
        return user;
    }
}
