package com.velocity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.velocity.model.DriverDetails;
import com.velocity.service.DriverDetailsService;

@RestController
@RequestMapping("/api/drivers")
public class DriverDetailsController {
    
    @Autowired
    private DriverDetailsService driverDetailsService;
    
    // Create a new driver
    @PostMapping
    public ResponseEntity<DriverDetails> createDriverDetails(@RequestBody DriverDetails driverDetails) {
        DriverDetails savedDriver = driverDetailsService.createDriverDetails(driverDetails);
        return new ResponseEntity<>(savedDriver, HttpStatus.CREATED);
    }
    
    // Get all drivers
    @GetMapping
    public ResponseEntity<List<DriverDetails>> getAllDriverDetails() {
        List<DriverDetails> drivers = driverDetailsService.getAllDriverDetails();
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }
    
    // Get driver by ID
    @GetMapping("/{id}")
    public ResponseEntity<DriverDetails> getDriverDetailsById(@PathVariable Long id) {
        Optional<DriverDetails> driver = driverDetailsService.getDriverDetailsById(id);
        return driver.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    // Update driver by ID
    @PutMapping("/{id}")
    public ResponseEntity<DriverDetails> updateDriverDetails(@PathVariable Long id, @RequestBody DriverDetails driverDetails) {
        DriverDetails updatedDriver = driverDetailsService.updateDriverDetails(id, driverDetails);
        if (updatedDriver != null) {
            return new ResponseEntity<>(updatedDriver, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Delete driver by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriverDetails(@PathVariable Long id) {
        driverDetailsService.deleteDriverDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
