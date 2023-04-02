package com.example.databasedesign.controller;

import com.example.databasedesign.bean.Classroom;
import com.example.databasedesign.bean.Instructor;
import com.example.databasedesign.bean.Student;
import com.example.databasedesign.service.ClassroomService;
import com.example.databasedesign.service.InstructorService;
import com.example.databasedesign.service.StudentService;
import com.example.databasedesign.utils.Result;
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
@CrossOrigin
public class ManagerController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private InstructorService instructorService;

    @RequestMapping("/student/insert")
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

    @RequestMapping("/student/select")
    public Map<String, Object> selectStudent(@RequestBody Map<String, Object> params){
        System.out.println("SELECT STUDENT");
        System.out.println(params);
        Map<String, Object> res = new HashMap<>();
        List<Student> studentList = studentService.selectStudent((String) params.get("dept_name"), (String) params.get("name"));
        return pageHelper(studentList, (Integer) params.get("pageIndex"), (Integer) params.get("pageSize"));
    }

    @RequestMapping("/student/update")
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

    @RequestMapping("/student/delete")
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

    @RequestMapping("/classroom/insert")
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

    @RequestMapping("/classroom/select")
    public Map<String, Object> selectClassroom(@RequestBody Map<String, Object> params){
        System.out.println("SELECT CLASSROOM");
        System.out.println(params);
        List<Classroom> classroomList = classroomService.selectClassroom((String) params.get("building"), (String) params.get("room_number"));

        return pageHelper(classroomList, (Integer) params.get("pageIndex"), (Integer) params.get("pageSize"));
    }

    @RequestMapping("/classroom/update")
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

    @RequestMapping("/classroom/delete")
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

    @RequestMapping("/instructor/insert")
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

    @RequestMapping("/instructor/select")
    public Map<String, Object> selectInstructor(@RequestBody Map<String, Object> params){
        System.out.println("SELECT INSTRUCTOR");
        System.out.println(params);
        Map<String, Object> res = new HashMap<>();
        List<Instructor> instructorList = instructorService.selectInstructor((String) params.get("dept_name"), (String) params.get("name"));

        return pageHelper(instructorList, (Integer) params.get("pageIndex"), (Integer) params.get("pageSize"));
    }

    @RequestMapping("/instructor/update")
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

    @RequestMapping("/instructor/delete")
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
