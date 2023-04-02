package com.example.databasedesign.bean;

import java.util.Map;

public class Classroom {
    public String building;
    public String roomNumber;
    public Integer capacity;

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoomNum() {
        return roomNumber;
    }

    public void setRoomNum(String roomNum) {
        this.roomNumber = roomNum;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Classroom(String building, String roomNum, Integer capacity) {
        this.building = building;
        this.roomNumber = roomNum;
        this.capacity = capacity;
    }

    public Classroom(Map<String, Object> params){
        this.building = (String) params.get("building");
        this.roomNumber = (String) params.get("room_number");
        if(params.get("capacity") != null) this.capacity = Integer.parseInt((String) params.get("capacity"));
        else this.capacity = 0;
    }
}
