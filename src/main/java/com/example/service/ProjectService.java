package com.example.service;


import com.example.pojo.PageBean;
import com.example.pojo.Project;

import java.util.List;

public interface ProjectService {
    List<Project> list();

    void deleteById(Integer id);

    void add(Project project);

    List<Project> selectById(Integer id);

    void update(Project project);

    PageBean page(Integer page, Integer pageSize);

    List<Project> selectByStudentId(Integer id);
}
