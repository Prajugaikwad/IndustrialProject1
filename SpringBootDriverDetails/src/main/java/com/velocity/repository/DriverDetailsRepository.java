package com.velocity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velocity.model.DriverDetails;

public interface DriverDetailsRepository extends JpaRepository<DriverDetails, Long> {
}

