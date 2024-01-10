package com.example.service.impl;

import com.example.mapper.ProjectMapper;
import com.example.pojo.PageBean;
import com.example.pojo.Project;
import com.example.service.ProjectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> list() {

        return projectMapper.list();
    }

    @Override
    public void deleteById(Integer id) {
        projectMapper.deleteById(id);
    }

    @Override
    public void add(Project project) {
        project.setCreateTime(LocalDateTime.now());
        project.setUpdateTime(LocalDateTime.now());
        projectMapper.insert(project);
    }

    @Override
    public List<Project> selectById(Integer id) {
        return projectMapper.selectById(id);
    }

    @Override
    public void update(Project project) {
        project.setUpdateTime(LocalDateTime.now());
        projectMapper.update(project);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize) {
//        Long count = projectMapper.count();
//        Integer start = (page-1)*pageSize;
//        List<Project> projectList = projectMapper.page(start,pageSize);

        PageHelper.startPage(page,pageSize);
        List<Project> projectList = projectMapper.list();
        Page<Project> p = (Page<Project>)projectList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public List<Project> selectByStudentId(Integer id) {
        return projectMapper.selectBystudentId(id);
    }
}
