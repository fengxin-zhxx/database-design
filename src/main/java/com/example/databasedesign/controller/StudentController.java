package com.example.databasedesign.controller;

import com.example.databasedesign.bean.Student;
import com.example.databasedesign.service.StudentService;
import com.example.databasedesign.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.example.databasedesign.utils.Result.pageHelper;

@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/student/course")
    public Result selectCoursesByStudent(@RequestBody Map<String, Object> params){
        System.out.println("SELECT COURSE BY ID");
        System.out.println(params);
        List<Map<String, Object>> courseList = studentService.selectCoursesByStudentId((String) params.get("ID"));
        return pageHelper(courseList, (Integer) params.get("pageIndex"), (Integer) params.get("pageSize"));
    }

}
