package com.example.databasedesign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.databasedesign.bean.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CourseMapper extends BaseMapper<Course> {

    @Insert("insert into course values (#{courseId},#{title},#{deptName}, #{credits})")
    void insertCourse(Course course);

    @Select("select * from course")
    List<Course> selectAll();

    @Select("select * from course where title=#{title}")
    List<Course> selectCourseByTitle(String title);

    @Select("select * from course where dept_name=#{deptName}")
    List<Course> selectCourseByDeptName(String deptName);

    @Select("select * from course where dept_name=#{deptName} and title=#{title}")
    List<Course> selectCourseByyDeptNameAndTitle(String deptName, String title);

    @Update("update course set title=#{title}, dept_name=#{deptName}, credits=#{credits} " +
            "where course_id = #{courseId}")
    void updateCourse(Course course);

    @Delete("delete from course where course_id=#{courseId}")
    void deleteCourse(String courseId);


}
