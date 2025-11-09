package com.erp.ERP.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    // Add more fields as needed

    // Default constructor
    public Library() {}

    public Library(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
}
