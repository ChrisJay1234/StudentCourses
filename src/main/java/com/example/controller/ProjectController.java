package com.example.controller;

import com.example.pojo.PageBean;
import com.example.pojo.Project;
import com.example.pojo.Result;
import com.example.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequestMapping("/projects")
@RestController
public class ProjectController {
//    private static Logger log = LoggerFactory.getLogger(ProjectController.class);
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public Result list(){
        log.info("查询所有项目");
        List<Project> projectList = projectService.list();
        return Result.success(projectList);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除项目：",id);
        projectService.deleteById(id);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Project project){
        log.info("添加项目：",project);
        projectService.add(project);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result select(@PathVariable Integer id){
        log.info("id查询项目：",id);
        List<Project> projectList = projectService.selectById(id);
        return Result.success(projectList);
    }
    @GetMapping("/s/{id}")
    public Result selectByStudentId(@PathVariable Integer id){
        log.info("学生id查询已选项目：",id);
        List<Project> projectList = projectService.selectByStudentId(id);
        return Result.success(projectList);
    }
    @PutMapping
    public Result update(@RequestBody Project project){
        log.info("项目修改信息");
        projectService.update(project);
        return Result.success();
    }

    @GetMapping("/pg")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pageSize){
        log.info("分页查询");
        PageBean pageBean = projectService.page(page,pageSize);
        return Result.success(pageBean);
    }
}
