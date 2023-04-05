package com.example.databasedesign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.databasedesign.bean.Instructor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorMapper extends BaseMapper<Instructor> {
    @Insert("insert into instructor values(#{instructorId}, #{name}, #{deptName}, #{salary} , null ,null ,null)")
    void insertInstructor(Instructor instructor);

    @Select("select * from instructor")
    List<Instructor> selectAll();

    @Select("select * from instructor where ID=#{Id}")
    List<Instructor> selectInstructorById(String Id);

    @Select("select * from instructor where dept_name=#{deptName}")
    List<Instructor> selectInstructorByDeptName(String deptName);

    @Select("select * from instructor where name=#{name}")
    List<Instructor> selectInstructorByName(String name);

    @Select("select * from instructor where dept_name = #{deptName} and name = #{name}")
    List<Instructor> selectInstructorByDeptNameAndName(String deptName, String name);

    @Update("update instructor set name=#{name}, dept_name=#{deptName}, salary=#{salary} where ID=#{instructorId}")
    void updateInstructor(Instructor instructor);

    @Update("update instructor set name=#{name}, dept_name=#{deptName}, salary=#{salary} , i_tel=#{iTel} , i_address=#{iAddress}, i_password=#{iPassword}where ID=#{instructorId}")
    void updateInstructorSelfInfo(Instructor instructor);

    @Delete("delete from instructor where id=#{id}")
    void deleteInstructorById(String id);
}
