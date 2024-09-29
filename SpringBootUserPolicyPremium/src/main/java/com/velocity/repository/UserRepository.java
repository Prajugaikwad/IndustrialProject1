package com.velocity.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.velocity.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

