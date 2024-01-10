package com.example.service;

import com.example.pojo.Project;
import com.example.pojo.Team;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TeamService {
    List<Team> list();

    void deleteById(Integer id);

    void add(Team team);

    List<Project> selectById(Integer id);

    void update(Team team);
}
