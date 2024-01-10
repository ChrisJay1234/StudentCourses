package com.example.controller;

import com.example.pojo.Result;
import com.example.pojo.Student;
import com.example.pojo.Teacher;
import com.example.service.StudentService;
import com.example.service.TeacherService;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/login")
@RestController
public class LoginController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @PostMapping("/s")
    public Result login(@RequestBody Student student){
        log.info("学生登陆");
        Student s = studentService.login(student);
        if(s!=null){
            Map<String, Object> claims = new HashMap<>();
//            int id = s.getId();
            claims.put("id",s.getId());
            claims.put("username",s.getUsername());
            claims.put("name",s.getName());
            claims.put("info",s.getInfo());
            String jwt = JwtUtils.generateJwt(claims);
//            List data = new ArrayList<>();
//            data.add(id);
//            data.add(jwt);
            claims.put("token",jwt);
            return Result.success(claims);
        }
        return Result.error("用户名或密码失败");
    }
    @PostMapping("/t")
    public Result login(@RequestBody Teacher teacher){
        log.info("教师登陆");
        Teacher t = teacherService.login(teacher);
        if(t!=null){
            Map<String, Object> claims = new HashMap<>();
//            int id = t.getId();
            claims.put("id",t.getId());
            claims.put("username",t.getUsername());
            claims.put("name",t.getName());
            claims.put("info",t.getInfo());
            String jwt = JwtUtils.generateJwt(claims);
//            List data = new ArrayList<>();
//            data.add(id);
//            data.add(jwt);
            claims.put("token",jwt);
            return Result.success(claims);
        }
        return Result.error("用户名或密码失败");
    }
}
