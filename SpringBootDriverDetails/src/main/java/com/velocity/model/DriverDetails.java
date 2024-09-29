package com.velocity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DriverDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String licenseNumber;
    private String vehicleType;
    
    // Getters and setters
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
    
    public String getLicenseNumber() {
        return licenseNumber;
    }
    
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    
    public String getVehicleType() {
        return vehicleType;
    }
    
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
