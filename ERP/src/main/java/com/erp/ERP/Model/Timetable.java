package com.erp.ERP.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day;
    private String timeSlot;
    private String courseName;
    private String teacherName;
    private String roomNumber;

    // Default constructor
    public Timetable() {}

    public Timetable(String day, String timeSlot, String courseName, String teacherName, String roomNumber) {
        this.day = day;
        this.timeSlot = timeSlot;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.roomNumber = roomNumber;
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getDay() { return day; }
    public String getTimeSlot() { return timeSlot; }
    public String getCourseName() { return courseName; }
    public String getTeacherName() { return teacherName; }
    public String getRoomNumber() { return roomNumber; }

    public void setId(Long id) { this.id = id; }
    public void setDay(String day) { this.day = day; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
}
