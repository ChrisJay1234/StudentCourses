package com.example.mapper;

import com.example.pojo.Project;
import com.example.pojo.Team;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeamMapper {
    @Select("select * from team")
    List<Team> list();
    @Delete("delete from team where id = #{id}")
    void deleteById(Integer id);
    @Insert("insert into team (name,teacher,info,create_time,update_time) values (#{name},#{teacher},#{info},#{createTime},#{updateTime})")
    void add(Team team);
    @Select("select * from team where id = #{id}")
    List<Project> selectById(Integer id);
    @Update("update team set name=#{name},teacher=#{teacher},info=#{info},update_time=#{updateTime} where id =#{id}")
    void update(Team team);
}
