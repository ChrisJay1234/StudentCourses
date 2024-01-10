package com.example.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mapper.CourseMapper;
import com.example.mapper.HomeworkMapper;
import com.example.mapper.StudentMapper;
import com.example.mapper.TeacherMapper;
import com.example.pojo.Course;
import com.example.pojo.Homework;
import com.example.pojo.Student;
import com.example.pojo.Teacher;
import com.example.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    private HomeworkMapper homeworkMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public Map<String, String> createHomework(Map<String, String> data) {
        String title = data.get("title");
        String content = data.get("content");
        Integer courseId = Integer.parseInt(data.get("courseId"));
        Integer teacherId = Integer.parseInt(data.get("teacherId"));
        Map<String, String> map = new HashMap<>();
        if (title == null || title.length() == 0){
            map.put("error_message", "标题不能为空");
            return map;
        }
        if (title.length() > 100){
            map.put("error_message", "标题长度不能超过100");
            return map;
        }
        if (content == null || content.length() == 0){
            map.put("error_message", "内容不能为空");
            return map;
        }
        if (content.length() > 10000){
            map.put("error_message", "内容长度不能超过10000");
            return map;
        }
        QueryWrapper<Teacher> queryTeacher = new QueryWrapper<>();
        queryTeacher.eq("id", teacherId);

        List<Teacher> teachers = teacherMapper.selectList(queryTeacher);
        List<Course> courses = courseMapper.selectid(courseId);
        if (teachers.isEmpty()){
            System.out.println("这个老师不存在");
            map.put("error_message", "该用户没用创建作业的权限");
            return map;
        }
        if (courses.isEmpty()){
            System.out.println("该班级不存在");
            map.put("error_message", "该班级不存在");
            return map;
        }
        Date now = new Date();

        LocalDateTime localDateTime = LocalDateTime.ofInstant(now.toInstant(), ZoneId.systemDefault());

        // 对日期进行加法操作
        int hours = Integer.parseInt(data.get("hours"));
        int days = Integer.parseInt(data.get("days"));
        int minutes = Integer.parseInt(data.get("minutes"));
        LocalDateTime newDateTime = localDateTime.plusDays(days).plusHours(hours).plusMinutes(minutes); // 7天后，2小时后

        Date newDate = Date.from(newDateTime.atZone(ZoneId.systemDefault()).toInstant()); // 获取新的日期

        Homework homework = new Homework(null, teacherId, courseId, title, content, now, newDate);
        homeworkMapper.insert(homework);
        map.put("error_message", "success");
        return map;
    }

    @Override
    public Map<String, String> getHomework(Map<String, String> data) {
        Integer courseId = Integer.parseInt(data.get("courseId"));
        QueryWrapper<Homework> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("course_id", courseId);
        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        map.put("data", homeworkMapper.selectList(QueryWrapper).toString());
        return map;
    }
}
