package com.example.databasedesign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.databasedesign.bean.Classroom;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomMapper extends BaseMapper<Classroom> {
    @Insert("insert into classroom values (#{building},#{roomNumber},#{capacity})")
    void insertClassroom(Classroom classroom);

    @Select("select * from classroom")
    List<Classroom> selectAll();

    @Select("select * from classroom where room_number=#{roomNumber}")
    List<Classroom> selectClassroomByRoomNumber(String roomNumber);

    @Select("select * from classroom where building=#{building}")
    List<Classroom> selectClassroomByBuilding(String building);

    @Select("select * from classroom where building = #{building} and room_number = #{roomNumber}")
    List<Classroom> selectClassroomByBuildingAndRoomNumber(String building, String roomNumber);

    @Update("update classroom set capacity=#{capacity} where building=#{building} and room_number=#{roomNumber}")
    void updateClassroom(Classroom classroom);

    @Delete("delete from classroom where building=#{building} and room_number=#{roomNumber}")
    void deleteClassroom(String building, String roomNumber);
}
