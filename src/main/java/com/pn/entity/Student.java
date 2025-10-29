package com.pn.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生扩展信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private Long id;

    /**
     * 关联用户ID
     */
    private Long userId;

    /**
     * 学生学号，唯一
     */
    private String studentNo;

    /**
     * 所属学院ID
     */
    private Long collegeId;

    /**
     * 所属专业ID
     */
    private Long majorId;

    /**
     * 所属班级ID
     */
    private Long classId;

    /**
     * 入学年份
     */
    private String enrollmentYear;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;
}