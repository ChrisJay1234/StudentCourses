package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Course;
import com.example.pojo.Project;
import com.example.pojo.Student;
import com.example.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    @Select("select * from teacher")
    List<Teacher> list();
//    @Update("update teacher set team_id=#{teamId},update_time=#{updateTime} where id =#{id}")
    void updatepid(Teacher teacher);
    @Select("select * from teacher where username = #{username} and password = #{password}")
    Teacher getUandP(Teacher teacher);
    @Select("SELECT * FROM student WHERE course_id in (SELECT id FROM course WHERE team_id = (SELECT team_id FROM teacher WHERE id = #{id})) and coursestatus=0")
    List<Student> coursestudent(Integer id);
    @Select("SELECT * FROM course WHERE team_id in (SELECT team_id FROM teacher WHERE id = #{id})")
    List<Course> course(Integer id);
    @Select("SELECT * FROM student WHERE project_id in (SELECT id FROM project WHERE team_id = (SELECT team_id FROM teacher WHERE id = #{id})) and projectstatus=0")
    List<Student> projectstudent(Integer id);
    @Select("SELECT * FROM project WHERE team_id in (SELECT team_id FROM teacher WHERE id = #{id})")
    List<Project> project(Integer id);
    @Select("SELECT * FROM student WHERE course_id in (SELECT id FROM course WHERE team_id = (SELECT team_id FROM teacher WHERE id = #{id})) and coursestatus=1")
    List<Student> cingstudent(Integer id);
    @Select("SELECT * FROM student WHERE project_id in (SELECT id FROM project WHERE team_id = (SELECT team_id FROM teacher WHERE id = #{id})) and projectstatus=1")
    List<Student> pingstudent(Integer id);

//    List<Teacher> selectList(QueryWrapper<Teacher> queryTeacher);
}
