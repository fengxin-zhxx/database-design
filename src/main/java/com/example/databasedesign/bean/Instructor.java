package com.example.databasedesign.bean;

import java.util.Map;

public class Instructor {
    public String instructorId;
    public String name;
    public String deptName;
    public Double salary;

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Instructor(String studentId, String name, String deptName, Double salary) {
        this.instructorId = studentId;
        this.name = name;
        this.deptName = deptName;
        this.salary = salary;
    }

    public Instructor(Map<String, Object> params){
        this.instructorId = (String) params.get("ID");
        this.name = (String) params.get("name");
        this.deptName = (String) params.get("dept_name");
        if(params.get("salary") != null) this.salary = Double.parseDouble((String) params.get("salary"));
        else this.salary = 0.0;
    }
}
