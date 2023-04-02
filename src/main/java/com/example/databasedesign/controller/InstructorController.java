package com.example.databasedesign.controller;


import com.example.databasedesign.bean.Instructor;
import com.example.databasedesign.service.InstructorService;
import com.example.databasedesign.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/instructor")
@CrossOrigin
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @RequestMapping("/insert")
    public Result insertInstructor(@RequestBody Map<String, Object> params){
        System.out.println("INSERT INSTRUCTOR");
        System.out.println(params);
        try{
            instructorService.insertInstructor(new Instructor(params));
            System.out.println("插入成功!");
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/select")
    public Map<String, Object> selectInstructor(@RequestBody Map<String, Object> params){
        System.out.println("SELECT INSTRUCTOR");
        System.out.println(params);
        Map<String, Object> res = new HashMap<>();
        List<Instructor> instructorList = instructorService.selectInstructor((String) params.get("dept_name"), (String) params.get("name"));
        res.put("pagetotal", instructorList.size());

        Integer pindex = (Integer) params.get("pageIndex");
        Integer psize = (Integer) params.get("pageSize");
        if(pindex != null && psize != null){
            instructorList = instructorList.subList((pindex - 1) * psize, Math.min(pindex * psize, instructorList.size()));

        }
        res.put("data", instructorList);
        return res;
    }

    @RequestMapping("/update")
    public Result updateInstructor(@RequestBody Map<String, Object> params){
        System.out.println("UPDATE INSTRUCTOR");
        System.out.println(params);
        try{
            instructorService.updateInstructor(new Instructor(params));
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/delete")
    public Result deleteInstructor(@RequestBody Map<String, Object> params){
        System.out.println("DELETE INSTRUCTOR");
        System.out.println(params);
        try{
            instructorService.deleteInstructor((String) params.get("ID"));
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

}
