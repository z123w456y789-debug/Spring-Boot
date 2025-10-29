package com.pn.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户基础表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Long id;

    /**
     * 用户名(学号/工号)，唯一
     */
    private String username;

    /**
     * 加密后的密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 性别：男/女/其他
     */
    private String gender;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 角色：admin/teacher/student
     */
    private String role;

    /**
     * 头像URL
     */
    private String avatarUrl;

    /**
     * 账号状态：active/inactive/suspended
     */
    private String status;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;
}