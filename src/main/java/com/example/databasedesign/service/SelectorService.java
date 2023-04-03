package com.example.databasedesign.service;

import com.example.databasedesign.bean.Classroom;
import com.example.databasedesign.bean.Course;
import com.example.databasedesign.bean.Instructor;
import com.example.databasedesign.bean.Student;
import com.example.databasedesign.mapper.*;
import com.example.databasedesign.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SelectorService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassroomMapper classroomMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private InstructorMapper instructorMapper;
    @Autowired
    private SectionMapper sectionMapper;
    @Autowired
    private TeachesMapper teachesMapper;


    public List<Student> selectStudent(String deptName, String name){
        boolean d = StringUtil.isEmpty(deptName), n = StringUtil.isEmpty(name);
        if(d && n) return studentMapper.selectAll();
        if(!d && !n) return studentMapper.selectStudentByDeptNameAndName(deptName, name);
        if(!d) return studentMapper.selectStudentByDeptName(deptName);
        return studentMapper.selectStudentByName(name);
    }

    public List<Classroom> selectClassroom(String building, String roomNumber){
        boolean b = StringUtil.isEmpty(building), r = StringUtil.isEmpty(roomNumber);
        if(b && r) return classroomMapper.selectAll();
        if(!b && !r) return classroomMapper.selectClassroomByBuildingAndRoomNumber(building, roomNumber);
        if(!r) return classroomMapper.selectClassroomByRoomNumber(roomNumber);
        return classroomMapper.selectClassroomByBuilding(building);
    }

    public List<Instructor> selectInstructor(String deptName, String name){
        boolean d = StringUtil.isEmpty(deptName), n = StringUtil.isEmpty(name);
        if(d && n) return instructorMapper.selectAll();
        if(!d && !n) return instructorMapper.selectInstructorByDeptNameAndName(deptName, name);
        if(!d) return instructorMapper.selectInstructorByDeptName(deptName);
        return instructorMapper.selectInstructorByName(name);
    }

    public List<Course> selectCourse(String deptName, String title){
        boolean d = StringUtil.isEmpty(deptName), t = StringUtil.isEmpty(title);
        if(d && t) return courseMapper.selectAll();
        if(!d && !t) return courseMapper.selectCourseByyDeptNameAndTitle(deptName, title);
        if(!d) return courseMapper.selectCourseByDeptName(deptName);
        return courseMapper.selectCourseByTitle(title);
    }


    public List<Map<String, Object>> selectAllSections(){return sectionMapper.selectAll();}

    public List<Map<String, Object>> selectSectionsByStudentId(String studentId, String title, String deptName){
        boolean s = StringUtil.isEmpty(studentId), t = StringUtil.isEmpty(title), d = StringUtil.isEmpty(deptName);
        if(!s){
            if(!t){
                if(!d){
                    // !s !t !d
                    return sectionMapper.selectSectionByTitleAndDeptNameAndStudentId(studentId, title, deptName);
                }else{
                    // !s !t d
                    return sectionMapper.selectSectionByTitleAndStudentId(studentId,title);
                }
            }else{
                if(!d){
                    // !s t !d
                    return  sectionMapper.selectSectionByDeptNameAndStudentId(studentId, deptName);
                }else{
                    //!s t d
                    return sectionMapper.selectSectionByStudentId(studentId);
                }
            }
        }else{
            return sectionMapper.selectAll();
        }

    }

    public List<Map<String, Object>> selectSectionsExceptStudent(String studentId, String title, String deptName){
        boolean s = StringUtil.isEmpty(studentId), t = StringUtil.isEmpty(title), d = StringUtil.isEmpty(deptName);
        if(!s){
            if(!t){
                if(!d){
                    // !s !t !d
                    return sectionMapper.selectSectionByTitleAndDeptNameExceptStudentId(studentId, title, deptName);
                }else{
                    // !s !t d
                    return sectionMapper.selectSectionByTitleExceptStudentId(studentId,title);
                }
            }else{
                if(!d){
                    // !s t !d
                    return  sectionMapper.selectSectionByDeptNameExceptStudentId(studentId, deptName);
                }else{
                    //!s t d
                    return sectionMapper.selectSectionExceptStudentId(studentId);
                }
            }
        }else{
            return sectionMapper.selectAll();
        }
    }

    public List<Map<String, Object>> selectSectionAndStudentByInstructorId(String instructorId, String title){
        boolean t = StringUtil.isEmpty(title);
        if(!t) return teachesMapper.selectSectionAndStudentByInstructorId(instructorId, title);
        else return teachesMapper.selectAllSectionAndStudentByInstructorId(instructorId);
    }

    public List<Map<String, Object>> selectSectionByInstructorId(String instructorId) {return teachesMapper.selectSectionByInstructorId(instructorId);}
}
