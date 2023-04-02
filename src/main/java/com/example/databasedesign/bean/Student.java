package com.example.databasedesign.bean;

import java.util.Map;

public class Student {
    public String studentId;
    public String name;
    public String deptName;
    public Integer totCred;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getTotCred() {
        return totCred;
    }

    public void setTotCred(Integer totCred) {
        this.totCred = totCred;
    }

    public Student(String studentId, String name, String deptName, Integer totCred) {
        this.studentId = studentId;
        this.name = name;
        this.deptName = deptName;
        this.totCred = totCred;
    }

    public Student(Map<String, Object> params){
        this.studentId = (String) params.get("ID");
        this.name = (String) params.get("name");
        this.deptName = (String) params.get("dept_name");
        if(params.get("tot_cred") != null) this.totCred = Integer.parseInt((String) params.get("tot_cred"));
        else this.totCred = 0;
    }
}
