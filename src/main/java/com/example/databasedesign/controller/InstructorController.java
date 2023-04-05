package com.example.databasedesign.controller;

import com.example.databasedesign.bean.Instructor;
import com.example.databasedesign.bean.Section;
import com.example.databasedesign.bean.Student;
import com.example.databasedesign.service.ManagerService;
import com.example.databasedesign.service.SelectorService;
import com.example.databasedesign.utils.Result;
import com.example.databasedesign.utils.StringUtil;
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
public class InstructorController {
    @Autowired
    private SelectorService selectorService;
    @Autowired
    private ManagerService managerService;

    @RequestMapping("/instructor/section")
    public Result selectInstructorSectionById(@RequestBody Map<String, Object> params){
        System.out.println("SELECT SECTION BY TEACHER ID");
        System.out.println(params);
        List<Map<String, Object>> courseList;
        if(!StringUtil.isEmpty((String) params.get("ID"))){
            courseList = selectorService.selectSectionByInstructorId((String) params.get("ID"));
        }else{
            courseList = selectorService.selectAllSections();
        }
        return pageHelper(courseList, (Integer) params.get("pageIndex"), (Integer) params.get("pageSize"));
    }

    @RequestMapping("/instructor/section_student")
    public Result selectInstructorSectionAndStudentById(@RequestBody Map<String, Object> params){
        System.out.println("SELECT SECTION AND STUDENT BY TEACHER ID");
        System.out.println(params);
        List<Map<String, Object>> courseList;
        courseList = selectorService.selectSectionAndStudentByInstructorId((String) params.get("ID"), (String) params.get("title"));

        return pageHelper(courseList, (Integer) params.get("pageIndex"), (Integer) params.get("pageSize"));
    }

    @RequestMapping("/instructor/assign_grade")
    public Result assignGradeToTakes(@RequestBody Map<String, Object> params){
        System.out.println("ASSIGN GRADE TO TAKES");
        System.out.println(params);
        try{
            String studentId = (String) params.get("ID");
            Section section = new Section(params);
            String grade = (String) params.get("grade");
            managerService.assignGradeToTakes(studentId, section, grade);
            return Result.ok();
        }catch(Exception e){
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/instructor/instructor_info")
    public Result getInformationForInstructor(@RequestBody Map<String, Object> params){
        System.out.println("Get Information For Instructor");
        System.out.println(params);
        List<Instructor> courseList = null;
        courseList = selectorService.selectInstructor((String) params.get("ID"));
        return pageHelper(courseList, (Integer) params.get("pageIndex"), (Integer) params.get("pageSize"));
    }

    @RequestMapping("/instructor/update_self_info")
    public Result updateStudent(@RequestBody Map<String, Object> params){
        System.out.println("UPDATE INSTRUCTOR SELF INFO");
        System.out.println(params);
        try{
            managerService.updateInstructorSelfInfo(new Instructor(params));
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }
}
