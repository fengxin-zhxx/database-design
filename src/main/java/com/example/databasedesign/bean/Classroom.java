package com.example.databasedesign.bean;

public class Classroom {
    public String building;
    public Integer roomNumber;
    public Integer capacity;

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Classroom(String building, Integer roomNumber, Integer capacity) {
        this.building = building;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }
}
