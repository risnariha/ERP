package com.erp.ERP.DTO;


public class StudentDTO {

    private Long id;
    private String name;
    private String email;
    private String department;
    private int year;

    // Default constructor
    public StudentDTO() {}

    public StudentDTO(Long id, String name, String email, String department, int year) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.year = year;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}
