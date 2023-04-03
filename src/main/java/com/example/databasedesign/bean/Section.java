package com.example.databasedesign.bean;

import java.util.Map;

public class Section {
    public String courseId;
    public String secId;
    public String semester;
    public Integer year;
    public String building;
    public String roomNumber;
    public String timeSlotId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(String timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public Section(String courseId, String secId, String semester, Integer year, String building, String roomNumber, String timeSlotId) {
        this.courseId = courseId;
        this.secId = secId;
        this.semester = semester;
        this.year = year;
        this.building = building;
        this.roomNumber = roomNumber;
        this.timeSlotId = timeSlotId;
    }

    public Section(Map<String, Object> params){
        this.courseId = (String) params.get("course_id");
        this.secId = (String) params.get("sec_id");
        this.semester = (String) params.get("semester");
        this.year = params.get("year") == null ? 0 : (Integer)params.get("year");
        this.building = (String) params.get("building");
        this.roomNumber = (String) params.get("room_number");
        this.timeSlotId = (String) params.get("time_slot_id");
    }
}
