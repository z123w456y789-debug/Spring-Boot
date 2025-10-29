package com.pn.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 学院表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class College implements Serializable {
    private Long id;

    /**
     * 学院名称
     */
    private String name;

    /**
     * 学院代码，唯一
     */
    private String code;

    /**
     * 学院描述
     */
    private String description;

    /**
     * 状态：active/inactive
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