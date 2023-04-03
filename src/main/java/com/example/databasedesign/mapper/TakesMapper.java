package com.example.databasedesign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.databasedesign.bean.Section;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface TakesMapper extends BaseMapper {
    @Insert("insert into takes values (#{studentId}, #{section.courseId}, #{section.secId}, #{section.semester}, #{section.year}, NULL)")
    void insertTakes(String studentId, Section section);

    @Delete("delete from takes where ID = #{studentId} and course_id = #{section.courseId} and sec_id = #{section.secId} " +
            "and semester = #{section.semester} and year = #{section.year}")
    void deleteTakes(String studentId, Section section);

    @Update("update takes set grade = #{grade} where ID = #{studentId} and course_id = #{section.courseId} and sec_id = #{section.secId} " +
            "and semester = #{section.semester} and year = #{section.year}" )
    void assignGradeToTakes(String studentId, Section section, String grade);
}
