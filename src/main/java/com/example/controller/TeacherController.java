package com.example.controller;

import com.example.pojo.*;
import com.example.service.ProjectService;
import com.example.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/teachers")
@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public Result list(){
        log.info("查询所有教师");
        List<Teacher> teacherList = teacherService.list();
        return Result.success(teacherList);
    }
    @GetMapping("/{id}")
    public Result coursestudent(@PathVariable Integer id){
        log.info("查询所有选课学生");
        List<Student> studentList = teacherService.coursestudent(id);
        return Result.success(studentList);
    }
    @GetMapping("cing/{id}")
    public Result cingstudent(@PathVariable Integer id){
        log.info("查询已经发送课程请求的学生");
        List<Student> studentList = teacherService.cingstudent(id);
        return Result.success(studentList);
    }
    @GetMapping("/course/{id}")
    public Result course(@PathVariable Integer id){
        log.info("查询所有的授课");
        List<Course> courseList = teacherService.course(id);
        return Result.success(courseList);
    }
    @GetMapping("/p/{id}")
    public Result projectstudent(@PathVariable Integer id){
        log.info("查询所有项目的学生");
        List<Student> studentList = teacherService.projectstudent(id);
        return Result.success(studentList);
    }

    @GetMapping("/project/{id}")
    public Result project(@PathVariable Integer id){
        log.info("查询所有的项目");
        List<Project> projectList = teacherService.project(id);
        return Result.success(projectList);
    }


    @GetMapping("ping/{id}")
    public Result pingstudent(@PathVariable Integer id){
        log.info("查询已经发送项目请求的学生");
        List<Student> studentList = teacherService.pingstudent(id);
        return Result.success(studentList);
    }

    @PutMapping
    public Result updatepid(@RequestBody Teacher teacher){
        log.info("修改教师信息");
        teacherService.updatepid(teacher);
        return Result.success();
    }
    @PutMapping("/confirm")
    public Result confirm(@RequestBody Student student){
        log.info("确认学生选课");
        teacherService.confirm(student);
        return Result.success();
    }
    @PutMapping("/confirmp")
    public Result confirmp(@RequestBody Student student){
        log.info("确认学生选项目");
        teacherService.confirmp(student);
        return Result.success();
    }
}
