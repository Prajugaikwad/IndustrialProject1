package com.velocity.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.velocity.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
