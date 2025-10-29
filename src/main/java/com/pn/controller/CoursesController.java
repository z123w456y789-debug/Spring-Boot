package com.pn.controller;

import com.pn.entity.Result;
import com.pn.entity.Course;
import com.pn.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursesController {

    // 注入CoursesService
    @Autowired
    private CoursesService coursesService;

    /**
     * 获取学生课程列表的url接口 /courses
     */
    @RequestMapping("/courses")
    public Result getStudentCourses() {
        try {
            // 执行业务 - 获取当前学生的课程列表
            List<Course> courses = coursesService.getStudentCourses();
            // 响应
            return Result.ok("获取课程列表成功", courses);
        } catch (RuntimeException e) {
            // 业务异常
            return Result.err(Result.CODE_ERR_BUSINESS, e.getMessage());
        } catch (Exception e) {
            // 系统异常
            e.printStackTrace();
            return Result.err(Result.CODE_ERR_SYS, "系统错误，请稍后重试");
        }
    }

    /**
     * 学生添加课程的url接口 /courses-add
     */
    @RequestMapping("/courses-add")
    public Result addStudentCourse(@RequestBody CourseAddRequest request) {
        try {
            // 执行业务 - 学生通过课程代码添加课程
            coursesService.addStudentCourse(request.getCourseCode());
            // 响应
            return Result.ok("课程添加成功");
        } catch (RuntimeException e) {
            // 业务异常
            return Result.err(Result.CODE_ERR_BUSINESS, e.getMessage());
        } catch (Exception e) {
            // 系统异常
            e.printStackTrace();
            return Result.err(Result.CODE_ERR_SYS, "系统错误，请稍后重试");
        }
    }

    // 请求参数类
    public static class CourseAddRequest {
        private String courseCode;

        public String getCourseCode() {
            return courseCode;
        }

        public void setCourseCode(String courseCode) {
            this.courseCode = courseCode;
        }
    }
}