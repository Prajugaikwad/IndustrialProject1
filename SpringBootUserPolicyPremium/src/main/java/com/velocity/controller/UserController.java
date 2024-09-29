package com.velocity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.velocity.dto.UserDTO;
import com.velocity.model.User;
import com.velocity.service.UserService;


import java.util.Optional;

@RestController

public class UserController {

    @Autowired
    private UserService userService;

    // POST method to get user details with policies and premiums
    @PostMapping("/details")
    public ResponseEntity<UserDTO> getUserWithPolicies(@RequestBody UserRequest userRequest) {
        Optional<User> userOptional = userService.getUserWithPolicies(userRequest.getUserId());

        if (userOptional.isPresent()) {
            UserDTO userDTO = userService.convertToUserDTO(userOptional.get());
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

