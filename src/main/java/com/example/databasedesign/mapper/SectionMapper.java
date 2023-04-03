package com.example.databasedesign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.databasedesign.bean.Section;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface SectionMapper extends BaseMapper<Section> {
    @Select("select * from section natural join course")
    List<Map<String, Object>> selectAll();

    @Select("select * from takes natural join course natural join section where ID = #{studentId}")
    List<Map<String, Object>> selectSectionByStudentId(String studentId);

    @Select("select * from takes natural join course natural join section where ID = #{studentId} and title = #{title} and dept_name = #{deptName}")
    List<Map<String, Object>> selectSectionByTitleAndDeptNameAndStudentId(String studentId, String title, String deptName);

    @Select("select * from takes natural join course natural join section where ID = #{studentId} and title = #{title}")
    List<Map<String, Object>> selectSectionByTitleAndStudentId(String studentId, String title);

    @Select("select * from takes natural join course natural join section where ID = #{studentId} and dept_name = #{deptName}")
    List<Map<String, Object>> selectSectionByDeptNameAndStudentId(String studentId, String deptName);

    @Select("select distinct * from course natural join section \n" +
            "where (course_id, sec_id, semester, year) not in \n" +
            "(select course_id, sec_id, semester, year from takes where ID = #{studentId}) \n")
    List<Map<String, Object>> selectSectionExceptStudentId(String studentId);

    @Select("select distinct * from course natural join section \n" +
            "where (course_id, sec_id, semester, year) not in \n" +
            "(select course_id, sec_id, semester, year from takes where ID = #{studentId}) \n" +
            "and title = #{title}")
    List<Map<String, Object>> selectSectionByTitleExceptStudentId(String studentId, String title);

    @Select("select distinct * from course natural join section \n" +
            "where (course_id, sec_id, semester, year) not in \n" +
            "(select course_id, sec_id, semester, year from takes where ID = #{studentId}) \n" +
            "and title = #{title} and dept_name = #{deptName}")
    List<Map<String, Object>> selectSectionByTitleAndDeptNameExceptStudentId(String studentId, String title, String deptName);

    @Select("select distinct * from course natural join section \n" +
            "where (course_id, sec_id, semester, year) not in \n" +
            "(select course_id, sec_id, semester, year from takes where ID = #{studentId}) \n" +
            "and dept_name = #{deptName}")
    List<Map<String, Object>> selectSectionByDeptNameExceptStudentId(String studentId,String deptName);
}
