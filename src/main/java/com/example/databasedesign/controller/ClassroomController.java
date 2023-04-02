package com.example.databasedesign.controller;


import com.example.databasedesign.bean.Classroom;
import com.example.databasedesign.service.ClassroomService;
import com.example.databasedesign.utils.Result;
import com.example.databasedesign.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.databasedesign.utils.helperUtil.pageHelper;

@RestController
@RequestMapping("/classroom")
@CrossOrigin
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @RequestMapping("/insert")
    public Result insertClassroom(@RequestBody Map<String, Object> params){
        System.out.println("INSERT CLASSROOM");
        System.out.println(params);
        try{
            classroomService.insertClassroom(new Classroom(params));
            System.out.println("插入成功!");
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/select")
    public Map<String, Object> selectClassroom(@RequestBody Map<String, Object> params){
        System.out.println("SELECT CLASSROOM");
        System.out.println(params);
        List<Classroom> classroomList = classroomService.selectClassroom((String) params.get("building"), (String) params.get("room_number"));

        return pageHelper(classroomList, (Integer) params.get("pageIndex"), (Integer) params.get("pageSize"));
    }

    @RequestMapping("/update")
    public Result updateClassroom(@RequestBody Map<String, Object> params){
        System.out.println("UPDATE CLASSROOM");
        System.out.println(params);
        try{
            classroomService.updateClassroom(new Classroom(params));
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/delete")
    public Result deleteClassroom(@RequestBody Map<String, Object> params){
        System.out.println("DELETE CLASSROOM");
        System.out.println(params);
        try{
            classroomService.deleteClassroom((String) params.get("building"), (String) params.get("room_number"));
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

}
