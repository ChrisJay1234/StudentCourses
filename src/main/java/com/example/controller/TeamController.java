package com.example.controller;

import com.example.pojo.Project;
import com.example.pojo.Result;
import com.example.pojo.Teacher;
import com.example.pojo.Team;
import com.example.service.TeacherService;
import com.example.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/teams")
@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public Result list(){
        log.info("查询所有教师团队");
        List<Team> teamList = teamService.list();
        return Result.success(teamList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除团队：",id);
        teamService.deleteById(id);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Team team){
        log.info("添加团队：",team);
        teamService.add(team);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result select(@PathVariable Integer id){
        log.info("id查询项目：",id);
        List<Project> projectList = teamService.selectById(id);
        return Result.success(projectList);
    }
    @PutMapping
    public Result update(@RequestBody Team team){
        log.info("项目修改信息");
        teamService.update(team);
        return Result.success();
    }
}
