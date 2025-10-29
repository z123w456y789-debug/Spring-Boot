package com.pn.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 班级表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class implements Serializable {
    private Long id;

    /**
     * 班级名称
     */
    private String name;

    /**
     * 班级代码
     */
    private String code;

    /**
     * 所属学院ID
     */
    private Long collegeId;

    /**
     * 所属专业ID
     */
    private Long majorId;

    /**
     * 班主任教师ID
     */
    private Long headTeacherId;

    /**
     * 年级
     */
    private String grade;

    /**
     * 学期
     */
    private String semester;

    /**
     * 学生人数
     */
    private Integer studentCount;

    /**
     * 毕业状态：studying/graduated
     */
    private String graduationStatus;

    /**
     * 状态：active/archived
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
