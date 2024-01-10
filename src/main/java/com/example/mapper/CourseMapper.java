package com.example.mapper;

import com.example.pojo.Course;
import com.example.pojo.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("select * from course")
    List<Course> list();

    @Delete("delete from course where id = #{id}")
    void deletebyid(Integer id);

    @Insert("insert into course (name,team_id,time,room,info,create_time,update_time) values (#{name},#{teamId},#{time},#{room},#{info},#{createTime},#{updateTime})")
    void insert(Course course);

    @Select("select * from course where id =#{id}")
    List<Course> selectid(Integer id);

//    @Update("update course set name=#{name},team_id=#{teamId},time=#{time},room = #{room}info=#{info},update_time=#{updateTime} where id =#{id}")
    void update(Course course);
    @Select("select * from course where id in (select course_id from student where id =#{id} and coursestatus =0)")
    List<Course> selectbystudentid(Integer id);
    @Select("select * from course where id != IFNULL((select course_id from student where id =#{id} and coursestatus !=1),0)")
    List<Course> selectWithoutId(Integer id);
}
