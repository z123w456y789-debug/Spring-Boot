package com.pn.service;

import com.pn.entity.Course;

import java.util.List;

public interface CoursesService {

    /**
     * 获取当前学生的课程列表
     */
    List<Course> getStudentCourses();

    /**
     * 学生通过课程代码添加课程
     */
    void addStudentCourse(String courseCode);
}