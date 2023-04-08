package com.example.databasedesign.controller;

import com.example.databasedesign.bean.Classroom;
import com.example.databasedesign.bean.Course;
import com.example.databasedesign.bean.Instructor;
import com.example.databasedesign.bean.Student;
import com.example.databasedesign.service.ManagerService;
import com.example.databasedesign.service.SelectorService;
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
public class AdministratorController {

    @Autowired
    private SelectorService selectorService;
    @Autowired
    private ManagerService managerService;

    @RequestMapping("/student/insert")
    public Result insertStudent(@RequestBody Map<String, Object> params){
        System.out.println("INSERT STUDENT");
        System.out.println(params);
        try{
            managerService.insertStudent(new Student(params));
            System.out.println("插入成功!");
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/student/select")
    public Result selectStudent(@RequestBody Map<String, Object> params){
        System.out.println("SELECT STUDENT");
        System.out.println(params);
        List<Student> studentList = selectorService.selectStudent((String) params.get("dept_name"), (String) params.get("name"));
        return pageHelper(studentList, (Integer) params.get("pageIndex"), (Integer) params.get("pageSize"));
    }

    @RequestMapping("/student/update")
    public Result updateStudent(@RequestBody Map<String, Object> params){
        System.out.println("UPDATE STUDENT");
        System.out.println(params);
        try{
            managerService.updateStudent(new Student(params));
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/student/delete")
    public Result deleteStudent(@RequestBody Map<String, Object> params){
        System.out.println("DELETE STUDENT");
        System.out.println(params);
        try{
            managerService.deleteStudent((String) params.get("ID"));
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/classroom/insert")
    public Result insertClassroom(@RequestBody Map<String, Object> params){
        System.out.println("INSERT CLASSROOM");
        System.out.println(params);
        try{
            managerService.insertClassroom(new Classroom(params));
            System.out.println("插入成功!");
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/classroom/select")
    public Result selectClassroom(@RequestBody Map<String, Object> params){
        System.out.println("SELECT CLASSROOM");
        System.out.println(params);
        List<Classroom> classroomList = selectorService.selectClassroom((String) params.get("building"), (String) params.get("room_number"));

        return pageHelper(classroomList, (Integer) params.get("pageIndex"), (Integer) params.get("pageSize"));
    }

    @RequestMapping("/classroom/update")
    public Result updateClassroom(@RequestBody Map<String, Object> params){
        System.out.println("UPDATE CLASSROOM");
        System.out.println(params);
        try{
            managerService.updateClassroom(new Classroom(params));
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/classroom/delete")
    public Result deleteClassroom(@RequestBody Map<String, Object> params){
        System.out.println("DELETE CLASSROOM");
        System.out.println(params);
        try{
            managerService.deleteClassroom((String) params.get("building"), (String) params.get("room_number"));
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/instructor/insert")
    public Result insertInstructor(@RequestBody Map<String, Object> params){
        System.out.println("INSERT INSTRUCTOR");
        System.out.println(params);
        try{
            managerService.insertInstructor(new Instructor(params));
            System.out.println("插入成功!");
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/instructor/select")
    public Result selectInstructor(@RequestBody Map<String, Object> params){
        System.out.println("SELECT INSTRUCTOR");
        System.out.println(params);
        List<Instructor> instructorList = selectorService.selectInstructor((String) params.get("dept_name"), (String) params.get("name"));

        return pageHelper(instructorList, (Integer) params.get("pageIndex"), (Integer) params.get("pageSize"));
    }

    @RequestMapping("/instructor/update")
    public Result updateInstructor(@RequestBody Map<String, Object> params){
        System.out.println("UPDATE INSTRUCTOR");
        System.out.println(params);
        try{
            managerService.updateInstructor(new Instructor(params));
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/instructor/delete")
    public Result deleteInstructor(@RequestBody Map<String, Object> params){
        System.out.println("DELETE INSTRUCTOR");
        System.out.println(params);
        try{
            managerService.deleteInstructor((String) params.get("ID"));
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }
    @RequestMapping("/course/insert")
    public Result insertCourse(@RequestBody Map<String, Object> params){
        System.out.println("INSERT COURSE");
        System.out.println(params);
        try{
            managerService.insertCourse(new Course(params));
            System.out.println("插入成功!");
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/course/select")
    public Result selectCourse(@RequestBody Map<String, Object> params){
        System.out.println("SELECT COURSE");
        System.out.println(params);
        List<Course> courseList = selectorService.selectCourse((String) params.get("dept_name"), (String) params.get("title"));

        return pageHelper(courseList, (Integer) params.get("pageIndex"), (Integer) params.get("pageSize"));
    }

    @RequestMapping("/course/update")
    public Result updateCourse(@RequestBody Map<String, Object> params){
        System.out.println("UPDATE COURSE");
        System.out.println(params);
        try{
            managerService.updateCourse(new Course(params));
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/course/delete")
    public Result deleteCourse(@RequestBody Map<String, Object> params){
        System.out.println("DELETE COURSE");
        System.out.println(params);
        try{
            managerService.deleteCourse((String) params.get("course_id"));
            return Result.ok();
        }catch (Exception e){
            System.out.println(e);
            return Result.error(e.getMessage());
        }
    }

}
