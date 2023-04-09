package com.example.databasedesign.bean;

import java.util.Map;

public class Course {
    public String courseId;
    public String title;
    public String deptName;
    public Integer credits;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Course(String courseId, String title, String deptName, Integer credits) {
        this.courseId = courseId;
        this.title = title;
        this.deptName = deptName;
        this.credits = credits;
    }

    public Course(Map<String, Object> params){
        this.courseId = (String) params.get("course_id");
        if(params.get("credits") != null){
            Object credits = params.get("credits");
            if(credits.getClass().equals(Integer.class)){
                this.credits = (Integer) params.get("credits");
            }else{
                this.credits = Integer.parseInt((String) params.get("credits"));
            }
        }else{
            this.credits = 0;
        }
        if(params.get("title") != null) this.title = (String) params.get("title");
        if(params.get("dept_name") != null) this.deptName = (String) params.get("dept_name");
    }
}
