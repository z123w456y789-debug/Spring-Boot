package com.pn.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {
    private Long id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 课程代码，唯一
     */
    private String courseCode;

    /**
     * 所属学院ID
     */
    private Long collegeId;

    /**
     * 课程分类
     */
    private String category;

    /**
     * 创建者教师ID
     */
    private Long creatorId;

    /**
     * 课程描述
     */
    private String description;

    /**
     * 课程封面图片URL
     */
    private String coverImage;

    /**
     * 状态：draft/published/archived
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createdAt;


    /**
     * 更新时间
     */
    private Date updatedAt;
    private String teacherName;
}
