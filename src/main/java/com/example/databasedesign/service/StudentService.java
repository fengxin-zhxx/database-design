package com.example.databasedesign.service;

import com.example.databasedesign.bean.Student;
import com.example.databasedesign.mapper.StudentMapper;
import com.example.databasedesign.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public void insertStudent(Student student){studentMapper.insertStudent(student);}

    public List<Student> selectStudent(String deptName, String name){
        boolean d = StringUtil.isEmpty(deptName), n = StringUtil.isEmpty(name);
        if(d && n) return studentMapper.selectAll();
        if(!d && !n) return studentMapper.selectStudentByDeptNameAndName(deptName, name);
        if(!d) return studentMapper.selectStudentByDeptName(deptName);
        return studentMapper.selectStudentByName(name);
    }

    public void updateStudent(Student student){studentMapper.updateStudent(student);}

    public void deleteStudent(String id){studentMapper.deleteStudentById(id);}

}
