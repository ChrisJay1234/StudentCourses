package com.example.mapper;

import com.example.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {
//    @Update("update student set username = #{username},name=#{name},project_id=#{projectId},update_time=#{updateTime} where id =#{id}")
    void update(Student student);
    @Select("select * from student")
    List<Student> list();
//    @Update("update s set project_id=#{projectId},update_time=#{updateTime} where id =#{id}")
    void updatepid(Student student);
    @Select("select * from student where username = #{username} and password = #{password}")
    Student getByUandP(Student student);
    @Update("update student set course_id=null,update_time=#{updateTime} where id =#{id}")
    void deletecourse(Student student);
//    @Update("update student set password= #{password},update_time=#{updateTime} where id =#{id}")
//    void updatepassword(Student student);
    @Update("update student set course_id = #{courseId},coursestatus = 1,update_time=#{updateTime} where id =#{id}")
    void updatec(Student student);
    @Update("update student set project_id = #{projectId},projectstatus = 1,update_time=#{updateTime} where id =#{id}")
    void updatep(Student student);
    @Update("update student set projectstatus = #{projectstatus},update_time=#{updateTime} where id =#{id}")
    void comfirmp(Student student);
}
