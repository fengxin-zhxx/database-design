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
    @Insert("insert into student values(#{studentId}, #{name}, #{deptName}, 0 , null , null , null)")
    void insertStudent(Student student);

    @Select("select * from student")
    List<Student> selectAll();

    @Select("select * from student where id=#{id}")
    List<Student> selectStudentById(String id);

    @Select("select * from student where dept_name=#{deptName}")
    List<Student> selectStudentByDeptName(String deptName);

    @Select("select * from student where name=#{name}")
    List<Student> selectStudentByName(String name);

    @Select("select * from student where dept_name = #{deptName} and name = #{name}")
    List<Student> selectStudentByDeptNameAndName(String deptName, String name);

    @Update("update student set name=#{name}, dept_name=#{deptName}, tot_cred=#{totCred}  where ID=#{studentId}")
    void updateStudent(Student student);

    @Update("update student set name=#{name}, dept_name=#{deptName}, tot_cred=#{totCred} , s_tel=#{sTel} , s_address=#{sAddress}, s_password=#{sPassword} where ID=#{studentId}")
    void updateStudentSelfInfo(Student student);

    @Delete("delete from student where id=#{id}")
    void deleteStudentById(String id);



}
