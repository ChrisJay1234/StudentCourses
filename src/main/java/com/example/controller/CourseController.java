package com.example.controller;

import com.example.pojo.*;
import com.example.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/course")
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public Result list(){
        log.info("查询所有课程");
        List<Course> courseList = courseService.list();
        return Result.success(courseList);
    }
    @GetMapping("/id/{id}")
    public Result selectWithoutId(@PathVariable Integer id){
        log.info("剩余可选课程：",id);
        List<Course> courseList = courseService.selectWithoutId(id);
        return Result.success(courseList);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除课程：",id);
        courseService.deleteById(id);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Course course){
        log.info("添加项目：",course);
        courseService.add(course);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result select(@PathVariable Integer id){
        log.info("id查询项目：",id);
        List<Course> courseList = courseService.selectById(id);
        return Result.success(courseList);
    }
    @GetMapping("/s/{id}")
    public Result selectByStudentId(@PathVariable Integer id){
        log.info("学生id查询已选项目：",id);
        List<Course> courseList = courseService.selectByStudentId(id);
        return Result.success(courseList);
    }

    @PutMapping
    public Result update(@RequestBody Course course){
        log.info("课程修改信息");
        courseService.update(course);
        return Result.success();
    }

    @GetMapping("/pg")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pageSize){
        log.info("分页查询");
        PageBean pageBean = courseService.page(page,pageSize);
        return Result.success(pageBean);
    }

}
