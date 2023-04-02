package com.example.databasedesign.controller;


import com.example.databasedesign.bean.Student;
import com.example.databasedesign.service.StudentService;
import com.example.databasedesign.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.databasedesign.utils.helperUtil.pageHelper;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/insert")
    public Result insertStudent(@RequestBody Map<String, Object> params){
        System.out.println("INSERT STUDENT");
        System.out.println(params);
        try{
            studentService.insertStudent(new Student(params));
            System.out.println("插入成功!");
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/select")
    public Map<String, Object> selectStudent(@RequestBody Map<String, Object> params){
        System.out.println("SELECT STUDENT");
        System.out.println(params);
        Map<String, Object> res = new HashMap<>();
        List<Student> studentList = studentService.selectStudent((String) params.get("dept_name"), (String) params.get("name"));
        return pageHelper(studentList, (Integer) params.get("pageIndex"), (Integer) params.get("pageSize"));
    }

    @RequestMapping("/update")
    public Result updateStudent(@RequestBody Map<String, Object> params){
        System.out.println("UPDATE STUDENT");
        System.out.println(params);
        try{
            studentService.updateStudent(new Student(params));
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/delete")
    public Result deleteStudent(@RequestBody Map<String, Object> params){
        System.out.println("DELETE STUDENT");
        System.out.println(params);
        try{
            studentService.deleteStudent((String) params.get("ID"));
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

}
