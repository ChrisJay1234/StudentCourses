package com.example.service;

import com.example.pojo.Student;

import java.util.List;


public interface StudentService {

    void update(Student student);

    List<Student> list();

    void updatec(Student student);

    Student login(Student student);

    void deletecourse(Student student);

    void updatep(Student student);
}
