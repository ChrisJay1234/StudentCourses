package com.example.controller;

import com.example.mapper.HomeworkMapper;
import com.example.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeworkController {
    @Autowired
    private HomeworkService homeworkService;

    @PostMapping("/homework/create")
    public Map<String, String> createHomework(@RequestParam Map<String, String> data){
        return homeworkService.createHomework(data);
    }

    @PostMapping("/homework/get")
    public Map<String, String> getHomework(@RequestParam Map<String, String> data){

        return homeworkService.getHomework(data);
    }
}
