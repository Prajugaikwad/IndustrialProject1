package com.velocity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velocity.model.DriverDetails;
import com.velocity.repository.DriverDetailsRepository;

@Service
public class DriverDetailsService {
    
    @Autowired
    private DriverDetailsRepository driverDetailsRepository;
    
    public DriverDetails createDriverDetails(DriverDetails driverDetails) {
        return driverDetailsRepository.save(driverDetails);
    }
    
    public List<DriverDetails> getAllDriverDetails() {
        return driverDetailsRepository.findAll();
    }
    
    public Optional<DriverDetails> getDriverDetailsById(Long id) {
        return driverDetailsRepository.findById(id);
    }
    
    public DriverDetails updateDriverDetails(Long id, DriverDetails driverDetails) {
        Optional<DriverDetails> existingDriver = driverDetailsRepository.findById(id);
        
        if (existingDriver.isPresent()) {
            DriverDetails updatedDriver = existingDriver.get();
            updatedDriver.setName(driverDetails.getName());
            updatedDriver.setLicenseNumber(driverDetails.getLicenseNumber());
            updatedDriver.setVehicleType(driverDetails.getVehicleType());
            return driverDetailsRepository.save(updatedDriver);
        } else {
            return null;
        }
    }
    
    public void deleteDriverDetails(Long id) {
        driverDetailsRepository.deleteById(id);
    }
}
