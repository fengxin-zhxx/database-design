package com.example.databasedesign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.databasedesign.bean.Section;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface TakesMapper extends BaseMapper {
    @Insert("insert into takes values (#{studentId}, #{section.courseId}, #{section.secId}, #{section.semester}, #{section.year}, NULL)")
    void insertTakes(String studentId, Section section);
}
