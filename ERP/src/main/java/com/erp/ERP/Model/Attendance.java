package com.erp.ERP.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;    // Reference to the student (or use a @ManyToOne relation if you wish)
    private String date;       // Store date as a string, or use LocalDate for best practice
    private Boolean present;   // true if present, false if absent

    // Default constructor
    public Attendance() {}

    // Constructor with fields
    public Attendance(Long studentId, String date, Boolean present) {
        this.studentId = studentId;
        this.date = date;
        this.present = present;
    }

    // Getters
    public Long getId() { return id; }
    public Long getStudentId() { return studentId; }
    public String getDate() { return date; }
    public Boolean getPresent() { return present; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public void setDate(String date) { this.date = date; }
    public void setPresent(Boolean present) { this.present = present; }
}
