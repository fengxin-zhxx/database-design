package com.example.databasedesign.service;

import com.example.databasedesign.bean.*;
import com.example.databasedesign.mapper.*;
import com.example.databasedesign.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassroomMapper classroomMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private InstructorMapper instructorMapper;
    @Autowired
    private TakesMapper takesMapper;

    public void insertCourse(Course course){courseMapper.insertCourse(course);}

    public void updateCourse(Course course){courseMapper.updateCourse(course);}

    public void deleteCourse(String courseId){courseMapper.deleteCourse(courseId);}

    public void insertClassroom(Classroom classroom){classroomMapper.insertClassroom(classroom);}

    public void updateClassroom(Classroom classroom){classroomMapper.updateClassroom(classroom);}

    public void deleteClassroom(String building, String room_number){classroomMapper.deleteClassroom(building, room_number);}

    public void insertStudent(Student student){studentMapper.insertStudent(student);}public void updateStudent(Student student){studentMapper.updateStudent(student);}

    public void deleteStudent(String id){studentMapper.deleteStudentById(id);}

    public void insertInstructor(Instructor instructor){instructorMapper.insertInstructor(instructor);}

    public void updateInstructor(Instructor instructor){instructorMapper.updateInstructor(instructor);}

    public void deleteInstructor(String id){instructorMapper.deleteInstructorById(id);}

    public void insertTakes(String studentId, Section section){takesMapper.insertTakes(studentId, section);}

    public void deleteSection(String studentId, Section section) {takesMapper.deleteTakes(studentId, section);}

    public void assignGradeToTakes(String studentId, Section section, String grade) {takesMapper.assignGradeToTakes(studentId, section, grade);}
}
