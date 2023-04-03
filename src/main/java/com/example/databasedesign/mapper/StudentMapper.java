package com.example.databasedesign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.databasedesign.bean.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentMapper extends BaseMapper<Student> {
    @Insert("insert into student values(#{studentId}, #{name}, #{deptName}, 0)")
    void insertStudent(Student student);

    @Select("select * from student")
    List<Student> selectAll();

    @Select("select * from student where dept_name=#{deptName}")
    List<Student> selectStudentByDeptName(String deptName);

    @Select("select * from student where name=#{name}")
    List<Student> selectStudentByName(String name);

    @Select("select * from student where dept_name = #{deptName} and name = #{name}")
    List<Student> selectStudentByDeptNameAndName(String deptName, String name);

    @Update("update student set name=#{name}, dept_name=#{deptName}, tot_cred=#{totCred} where ID=#{studentId}")
    void updateStudent(Student student);

    @Delete("delete from student where id=#{id}")
    void deleteStudentById(String id);

    @Select("select course_id, title, sec_id, dept_name, semester, year, grade from takes natural join course where ID = #{studentId}")
    List<Map<String, Object>> selectCourseByStudentId(String studentId);

}
