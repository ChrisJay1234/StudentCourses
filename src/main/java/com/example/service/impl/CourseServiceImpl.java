package com.example.service.impl;

import com.example.mapper.CourseMapper;
import com.example.pojo.Course;
import com.example.pojo.PageBean;
import com.example.pojo.Project;
import com.example.service.CourseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> list() {
        return courseMapper.list();
    }

    @Override
    public void deleteById(Integer id) {
        courseMapper.deletebyid(id);
    }

    @Override
    public void add(Course course) {
        course.setCreateTime(LocalDateTime.now());
        course.setUpdateTime(LocalDateTime.now());
        courseMapper.insert(course);
    }

    @Override
    public List<Course> selectById(Integer id) {
        return courseMapper.selectid(id);
    }

    @Override
    public void update(Course course) {
        course.setUpdateTime(LocalDateTime.now());
        courseMapper.update(course);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Course> courseList = courseMapper.list();
        Page<Course> p = (Page<Course>)courseList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public List<Course> selectByStudentId(Integer id) {
        return courseMapper.selectbystudentid(id);
    }

    @Override
    public List<Course> selectWithoutId(Integer id) {
        return courseMapper.selectWithoutId(id);
    }
}
