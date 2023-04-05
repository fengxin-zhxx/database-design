package com.example.databasedesign.bean;

import java.util.Map;

public class Student {
    public String studentId;
    public String name;
    public String deptName;
    public Integer totCred;
    public String sTel;
    public String sAddress;
    public String sPassword;

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

    public Student(String studentId, String name, String deptName, Integer totCred, String sTel,String sAddress ,String sPassword) {
        this.studentId = studentId;
        this.name = name;
        this.deptName = deptName;
        this.totCred = totCred;
        this.sTel = sTel;
        this.sAddress = sAddress;
        this.sPassword = sPassword;
    }

    public Student(Map<String, Object> params){
        this.studentId = (String) params.get("ID");
        this.name = (String) params.get("name");
        this.deptName = (String) params.get("dept_name");
        if(params.get("tot_cred") != null) this.totCred = Integer.parseInt((String) params.get("tot_cred"));
        else this.totCred = 0;
        if(params.get("s_tel") != null) this.sTel = (String) params.get("s_tel");
        if(params.get("s_address") != null) this.sAddress = (String) params.get("s_address");
        if(params.get("s_password") != null) this.sPassword = (String) params.get("s_password");
    }
}
