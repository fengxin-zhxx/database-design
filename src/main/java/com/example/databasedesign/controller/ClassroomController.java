package com.example.databasedesign.controller;


import com.example.databasedesign.bean.Classroom;
import com.example.databasedesign.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/classroom")
@CrossOrigin
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @RequestMapping("/all")
    public Map<String,Object> getAll(){
        Map<String,Object> res = new HashMap<>();
        List<Classroom> courseList = classroomService.findAll();
        res.put("data",courseList);
        res.put("pagetotal",courseList.size());
        return res;
    }
}
