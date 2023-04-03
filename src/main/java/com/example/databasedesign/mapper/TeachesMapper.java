package com.example.databasedesign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TeachesMapper extends BaseMapper {
    @Select("select course_id, title, dept_name, sec_id, semester, year, building, room_number, time_slot_id " +
            "from (teaches natural join course) natural join section where ID = #{instructorId} ")
    List<Map<String, Object>> selectSectionByInstructorId(String instructorId);

    @Select("select \n" +
            "student.ID ID,\n" +
            "student.name name,\n" +
            "course.dept_name dept_name,\n" +
            "course_id,\n" +
            "title,\n" +
            "sec_id,\n" +
            "semester,\n" +
            "year,\n" +
            "grade,\n" +
            "(case grade when NULL then 11 when \"A+\" then 10  when \"A\" then 9  when \"A-\" then 8  when \"B+\" then 7  when \"B\" then 6  when \"B-\" then 5  when \"C+\" then 4  when \"C\" then 3  when \"C-\" then 2 else 1 end) score\n" +
            "from ((teaches natural join course) join (student natural join takes)  using (course_id, sec_id, semester, year))\n" +
            "where teaches.ID = #{instructorId} and title = #{title} \n" +
            "order by score desc")
    List<Map<String, Object>> selectSectionAndStudentByInstructorId(String instructorId, String title);

    @Select("select \n" +
            "student.ID ID,\n" +
            "student.name name,\n" +
            "course.dept_name dept_name,\n" +
            "course_id,\n" +
            "title,\n" +
            "sec_id,\n" +
            "semester,\n" +
            "year,\n" +
            "grade,\n" +
            "(case grade when NULL then 11 when \"A+\" then 10  when \"A\" then 9  when \"A-\" then 8  when \"B+\" then 7  when \"B\" then 6  when \"B-\" then 5  when \"C+\" then 4  when \"C\" then 3  when \"C-\" then 2 else 1 end) score\n" +
            "from ((teaches natural join course) join (student natural join takes)  using (course_id, sec_id, semester, year))\n" +
            "where teaches.ID = #{instructorId} \n" +
            "order by score desc")
    List<Map<String, Object>> selectAllSectionAndStudentByInstructorId(String instructorId);
}
