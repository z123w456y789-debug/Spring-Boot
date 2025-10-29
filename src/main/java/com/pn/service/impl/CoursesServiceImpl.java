package com.pn.service.impl;

import com.pn.entity.Course;
import com.pn.mapper.CoursesMapper;
import com.pn.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {

    @Autowired
    private CoursesMapper coursesMapper;

    // 这里需要获取当前登录用户信息，可以通过ThreadLocal或Session等方式
    // 假设我们有一个工具类可以获取当前用户
    private String getCurrentUsername() {
        // 实际项目中这里应该从SecurityContext或Session中获取当前登录用户名
        // 这里先返回一个模拟值，你需要根据你的认证系统调整
        // 注意：这个用户名必须在users表中存在且角色是student
        return "20221819402022"; // 模拟当前登录学生的学号
    }

    @Override
    public List<Course> getStudentCourses() {
        // 获取当前登录学生的用户名
        String username = getCurrentUsername();

        // 根据用户名获取学生ID
        Long studentId = coursesMapper.findStudentIdByUsername(username);
        if (studentId == null) {
            throw new RuntimeException("学生信息不存在！");
        }

        // 查询学生的课程列表
        List<Course> courses = coursesMapper.findCoursesByStudentId(studentId);
        return courses;
    }

    @Override
    public void addStudentCourse(String courseCode) {
        // 参数校验
        if (!StringUtils.hasText(courseCode)) {
            throw new RuntimeException("课程代码不能为空！");
        }

        // 获取当前登录学生的用户名
        String username = getCurrentUsername();

        // 根据用户名获取学生ID
        Long studentId = coursesMapper.findStudentIdByUsername(username);
        if (studentId == null) {
            throw new RuntimeException("学生信息不存在！");
        }

        // 根据课程代码查询课程信息
        Course course = coursesMapper.findCourseByCode(courseCode);
        if (course == null) {
            throw new RuntimeException("课程代码不存在或课程未发布！");
        }

        // 检查学生是否已经选过该课程
        int enrollmentCount = coursesMapper.checkCourseEnrollment(studentId, course.getId());
        if (enrollmentCount > 0) {
            throw new RuntimeException("您已经选过该课程！");
        }

        // 学生选课
        int result = coursesMapper.enrollCourse(studentId, course.getId());
        if (result == 0) {
            throw new RuntimeException("选课失败，请稍后重试！");
        }
    }
}