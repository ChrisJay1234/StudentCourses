package com.example.service.impl;

import com.example.mapper.StudentMapper;
import com.example.pojo.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public List<Student> list() {
        return studentMapper.list();
    }

    @Override
    public void updatec(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updatec(student);
    }

    @Override
    public Student login(Student student) {
        return studentMapper.getByUandP(student);
    }

    @Override
    public void deletecourse(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.deletecourse(student);
    }

    @Override
    public void updatep(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updatep(student);
    }
}
