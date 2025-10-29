package com.pn.controller;

import com.pn.entity.Result;
import com.pn.entity.User;
import com.pn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    //注入UserService
    @Autowired
    private UserService userService;

    //学生登录的url接口 /login
    @RequestMapping("/login")
    public Result studentLogin(String username, String password) {
        try {
            //执行业务
            User user = userService.studentLogin(username, password);
            //响应
            return Result.ok("登录成功", user);
        } catch (RuntimeException e) {
            //业务异常
            return Result.err(Result.CODE_ERR_BUSINESS, e.getMessage());
        } catch (Exception e) {
            //系统异常
            e.printStackTrace();
            return Result.err(Result.CODE_ERR_SYS, "系统错误，请稍后重试");
        }
    }
}