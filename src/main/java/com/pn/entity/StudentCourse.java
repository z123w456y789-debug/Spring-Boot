package com.pn.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生选课表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourse implements Serializable {
    private Long id;

    /**
     * 学生ID
     */
    private Long studentId;

    /**
     * 课程ID
     */
    private Long courseId;

    /**
     * 课程班级关联ID
     */
    private Long courseClassId;

    /**
     * 加入课程时间
     */
    private Date joinTime;

    /**
     * 状态：studying/completed/dropped
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
}
