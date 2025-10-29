package com.pn.mapper;

import com.pn.entity.User;

public interface UserMapper {
    public User findUserByUsername(String username);
    public int updateLastLoginTime(Integer userId);
}