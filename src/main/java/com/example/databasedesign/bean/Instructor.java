package com.example.databasedesign.bean;

import java.util.Map;

public class Instructor {
    public String instructorId;
    public String name;
    public String deptName;
    public Double salary;
    public String iTel;
    public String iAddress;
    public String iPassword;

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

    public Instructor(String studentId, String name, String deptName, Double salary , String iTel , String iAddress ,String iPassword) {
        this.instructorId = studentId;
        this.name = name;
        this.deptName = deptName;
        this.salary = salary;
        this.iTel = iTel;
        this.iAddress = iAddress;
        this.iPassword = iPassword;
    }

    public Instructor(Map<String, Object> params){
        this.instructorId = (String) params.get("ID");
        this.name = (String) params.get("name");
        this.deptName = (String) params.get("dept_name");
        if(params.get("salary") != null) {
            Object salary = params.get("salary");
            if(salary.getClass().equals(Double.class)){
                this.salary = (Double) salary;
            }else{
                this.salary = Double.parseDouble((String) salary);
            }
        }
        else this.salary = 0.0;
        if(params.get("i_tel") != null) this.iTel = (String) params.get("i_tel");
        if(params.get("i_address") != null) this.iAddress = (String) params.get("i_address");
        if(params.get("i_password") != null) this.iPassword = (String) params.get("i_password");
    }
}
