package com.pn.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 教师扩展信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {
    private Long id;

    /**
     * 关联用户ID
     */
    private Long userId;

    /**
     * 教师工号，唯一
     */
    private String teacherNo;

    /**
     * 所属学院ID
     */
    private Long collegeId;

    /**
     * 教师职称
     */
    private String title;

    /**
     * 入职日期
     */
    private Date employmentDate;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;
}