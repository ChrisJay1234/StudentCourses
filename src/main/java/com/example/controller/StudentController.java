package com.example.controller;

import com.example.pojo.Project;
import com.example.pojo.Result;
import com.example.pojo.Student;
import com.example.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public Result list(){
        log.info("查询所有学生");
        List<Student> studentList = studentService.list();
        return Result.success(studentList);
    }

    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学生信息");
        studentService.update(student);
        return Result.success();
    }

    @PutMapping("/idc")
    public Result updatec(@RequestBody Student student){
        log.info("根据学生id发送选课请求");
        studentService.updatec(student);
        return Result.success();
    }
    @PutMapping("/idp")
    public Result updatep(@RequestBody Student student){
        log.info("根据学生id发送选项目请求");
        studentService.updatep(student);
        return Result.success();
    }
    @PutMapping("/deletecourse")
    public Result deletecourse(@RequestBody Student student){
        log.info("退课");
        studentService.deletecourse(student);
        return Result.success();
    }

}
