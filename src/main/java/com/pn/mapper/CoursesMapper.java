package com.pn.mapper;

import com.pn.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoursesMapper {

    /**
     * 根据学生ID查询已选的课程列表
     */
    List<Course> findCoursesByStudentId(@Param("studentId") Long studentId);

    /**
     * 根据课程代码查询课程信息
     */
    Course findCourseByCode(@Param("courseCode") String courseCode);

    /**
     * 检查学生是否已经选过该课程
     */
    int checkCourseEnrollment(@Param("studentId") Long studentId, @Param("courseId") Long courseId);

    /**
     * 学生选课 - 插入student_courses表
     */
    int enrollCourse(@Param("studentId") Long studentId, @Param("courseId") Long courseId);

    /**
     * 根据用户名获取学生ID
     */
    Long findStudentIdByUsername(@Param("username") String username);
}