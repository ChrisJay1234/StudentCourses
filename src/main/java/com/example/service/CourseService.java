package com.example.service;

import com.example.pojo.Course;
import com.example.pojo.PageBean;
import com.example.pojo.Project;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {
    List<Course> list();

    void deleteById(Integer id);

    void add(Course course);

    List<Course> selectById(Integer id);

    void update(Course course);

    PageBean page(Integer page, Integer pageSize);

    List<Course> selectByStudentId(Integer id);

    List<Course> selectWithoutId(Integer id);
}
