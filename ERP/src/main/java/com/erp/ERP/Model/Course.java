package com.erp.ERP.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private String description;
    private Integer credits;

    // Default constructor
    public Course() {}

    // Constructor with fields
    public Course(String name, String code, String description, Integer credits) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.credits = credits;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCode() { return code; }
    public String getDescription() { return description; }
    public Integer getCredits() { return credits; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCode(String code) { this.code = code; }
    public void setDescription(String description) { this.description = description; }
    public void setCredits(Integer credits) { this.credits = credits; }
}
