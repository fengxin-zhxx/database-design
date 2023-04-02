package com.example.databasedesign.service;

import com.example.databasedesign.bean.Instructor;
import com.example.databasedesign.mapper.InstructorMapper;
import com.example.databasedesign.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    @Autowired
    private InstructorMapper instructorMapper;

    public void insertInstructor(Instructor instructor){instructorMapper.insertInstructor(instructor);}

    public List<Instructor> selectInstructor(String deptName, String name){
        boolean d = StringUtil.isEmpty(deptName), n = StringUtil.isEmpty(name);
        if(d && n) return instructorMapper.selectAll();
        if(!d && !n) return instructorMapper.selectInstructorByDeptNameAndName(deptName, name);
        if(!d) return instructorMapper.selectInstructorByDeptName(deptName);
        return instructorMapper.selectInstructorByName(name);
    }

    public void updateInstructor(Instructor instructor){instructorMapper.updateInstructor(instructor);}

    public void deleteInstructor(String id){instructorMapper.deleteInstructorById(id);}

}
