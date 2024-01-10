package com.example.service.impl;

import com.example.mapper.TeamMapper;
import com.example.pojo.Project;
import com.example.pojo.Team;
import com.example.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;
    @Override
    public List<Team> list() {
        return teamMapper.list();
    }

    @Override
    public void deleteById(Integer id) {
        teamMapper.deleteById(id);
    }

    @Override
    public void add(Team team) {
        team.setCreateTime(LocalDateTime.now());
        team.setUpdateTime(LocalDateTime.now());
        teamMapper.add(team);
    }

    @Override
    public List<Project> selectById(Integer id) {
        return teamMapper.selectById(id);
    }

    @Override
    public void update(Team team) {
        team.setUpdateTime(LocalDateTime.now());
        teamMapper.update(team);
    }
}
