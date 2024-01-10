package com.example.service.impl;

import com.example.mapper.StudentMapper;
import com.example.mapper.TeacherMapper;
import com.example.pojo.Course;
import com.example.pojo.Project;
import com.example.pojo.Student;
import com.example.pojo.Teacher;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Teacher> list() {
        return teacherMapper.list();
    }

    @Override
    public void updatepid(Teacher teacher) {
        teacher.setUpdateTime(LocalDateTime.now());
        teacherMapper.updatepid(teacher);
    }

    @Override
    public Teacher login(Teacher teacher) {
        return teacherMapper.getUandP(teacher);
    }

    @Override
    public List<Student> coursestudent(Integer id) {
        return teacherMapper.coursestudent(id);
    }

    @Override
    public List<Course> course(Integer id) {
        return teacherMapper.course(id);
    }

    @Override
    public void confirm(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updatepid(student);
    }

    @Override
    public List<Student> projectstudent(Integer id) {
        return teacherMapper.projectstudent(id);
    }

    @Override
    public List<Project> project(Integer id) {
        return teacherMapper.project(id);
    }

    @Override
    public void confirmp(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.comfirmp(student);
    }

    @Override
    public List<Student> cingstudent(Integer id) {
        return teacherMapper.cingstudent(id);
    }

    @Override
    public List<Student> pingstudent(Integer id) {
        return teacherMapper.pingstudent(id);
    }
}
