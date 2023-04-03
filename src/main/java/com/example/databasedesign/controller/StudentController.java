package com.example.databasedesign.controller;

import com.example.databasedesign.bean.Section;
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
public class StudentController {
    @Autowired
    private SelectorService selectorService;
    @Autowired
    private ManagerService managerService;

    @RequestMapping("/student/section_untaken")
    public Result selectUntakenSection(@RequestBody Map<String, Object> params){
        System.out.println("SELECT UNTAKEN COURSE BY ID");
        System.out.println(params);
        List<Map<String, Object>> courseList = null;

        courseList = selectorService.selectSectionsExceptStudent((String) params.get("ID"), (String) params.get("title"), (String) params.get("dept_name"));

        return pageHelper(courseList, (Integer) params.get("pageIndex"), (Integer) params.get("pageSize"));
    }

    @RequestMapping("/student/section_taken")
    public Result selectTakenSection(@RequestBody Map<String, Object> params){
        System.out.println("SELECT TAKEN COURSE BY ID");
        System.out.println(params);
        List<Map<String, Object>> courseList = null;
        if(params.get("ID") != null){
            courseList = selectorService.selectSectionsByStudentId((String) params.get("ID"), (String) params.get("title"), (String) params.get("dept_name"));
        }else{
            courseList = selectorService.selectAllSections();
        }
        return pageHelper(courseList, (Integer) params.get("pageIndex"), (Integer) params.get("pageSize"));
    }

    @RequestMapping("/student/select_section")
    public Result insertSectionForStudent(@RequestBody Map<String, Object> params){
        System.out.println("Insert Section For Student");
        System.out.println(params);
        try{
            Section section = new Section(params);
            managerService.insertTakes((String) params.get("ID"), section);
            System.out.println("选课成功!");
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/student/delete_section")
    public Result deleteSectionForStudent(@RequestBody Map<String, Object> params){
        System.out.println("Delete Section For Student");
        System.out.println(params);
        try{
            Section section = new Section(params);
            managerService.deleteSection((String) params.get("ID"), section);
            System.out.println("退课成功!");
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

}
