package com.example.databasedesign.service;


import com.example.databasedesign.bean.Classroom;
import com.example.databasedesign.mapper.ClassroomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {
    @Autowired
    private ClassroomMapper classroomMapper;
    public List<Classroom> findAll(){return classroomMapper.findAll();}

}
