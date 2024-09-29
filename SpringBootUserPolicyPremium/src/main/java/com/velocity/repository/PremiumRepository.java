package com.velocity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velocity.model.Premium;

public interface PremiumRepository extends JpaRepository<Premium, Long> {
}
