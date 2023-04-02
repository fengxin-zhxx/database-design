package com.example.databasedesign.service;

import com.example.databasedesign.bean.Classroom;
import com.example.databasedesign.mapper.ClassroomMapper;
import com.example.databasedesign.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {
    @Autowired
    private ClassroomMapper classroomMapper;

    public void insertClassroom(Classroom classroom){classroomMapper.insertClassroom(classroom);}

    public List<Classroom> selectClassroom(String building, String roomNumber){
        boolean b = StringUtil.isEmpty(building), r = StringUtil.isEmpty(roomNumber);
        if(b && r) return classroomMapper.selectAll();
        if(!b && !r) return classroomMapper.selectClassroomByBuildingAndRoomNumber(building, roomNumber);
        if(!r) return classroomMapper.selectClassroomByRoomNumber(roomNumber);
        return classroomMapper.selectClassroomByBuilding(building);
    }

    public void updateClassroom(Classroom classroom){classroomMapper.updateClassroom(classroom);}

    public void deleteClassroom(String building, String room_number){classroomMapper.deleteClassroom(building, room_number);}

}
