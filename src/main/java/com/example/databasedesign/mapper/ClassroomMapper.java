package com.example.databasedesign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.databasedesign.bean.Classroom;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomMapper extends BaseMapper<Classroom> {
    @Select("select * from classroom")
    List<Classroom> findAll();

}
