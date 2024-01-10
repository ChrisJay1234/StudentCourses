package com.example.mapper;

import com.example.pojo.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {


    @Select("select * from project")
    List<Project> list();

    @Delete("delete from project where id = #{id}")
    void deleteById(Integer id);
    @Insert("insert into project (name,team_id,info,create_time,update_time) values (#{name},#{teamId},#{info},#{createTime},#{updateTime})")
    void insert(Project project);
    @Select("select * from project where id = #{id}")
    List<Project> selectById(Integer id);
//    @Update("update project_copy1 set name=#{name},team_id=#{teamId},info=#{info},update_time=#{updateTime} where id =#{id}")
    void update(Project project);
    @Select("select * from project where id = (select project_id from student where id =#{id} and projectstatus = 0)")
    List<Project> selectBystudentId(Integer id);


    //分页查询
//    @Select("select count(*) from project_copy1")
//    public Long count();
//    @Select("select * from project_copy1 limit #{start},#{pageSize}")
//    public List<Project> page(Integer start,Integer pageSize);
}
