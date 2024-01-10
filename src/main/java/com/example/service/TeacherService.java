package com.example.service;

import com.example.pojo.Course;
import com.example.pojo.Project;
import com.example.pojo.Student;
import com.example.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> list();

    void updatepid(Teacher teacher);

    Teacher login(Teacher teacher);

    List<Student> coursestudent(Integer id);

    List<Course> course(Integer id);

    void confirm(Student student);

    List<Student> projectstudent(Integer id);

    List<Project> project(Integer id);

    void confirmp(Student student);

    List<Student> cingstudent(Integer id);

    List<Student> pingstudent(Integer id);
}
