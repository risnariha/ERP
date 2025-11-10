package com.erp.ERP.Model           ;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String examName;
    private String subject;
    private String date; // You may use LocalDate for best practice

    // Default constructor
    public Exam() {}

    // Constructor with fields
    public Exam(String examName, String subject, String date) {
        this.examName = examName;
        this.subject = subject;
        this.date = date;
    }

    // Getters
    public Long getId() { return id; }
    public String getExamName() { return examName; }
    public String getSubject() { return subject; }
    public String getDate() { return date; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setExamName(String examName) { this.examName = examName; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setDate(String date) { this.date = date; }
}
