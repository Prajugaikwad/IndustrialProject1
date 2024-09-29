package com.velocity.dto;

import java.util.List;

public class UserDTO {
    private int id;
    private String name;
    private String email;
    private List<PolicyDTO> policies;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<PolicyDTO> getPolicies() {
        return policies;
    }

    public void setPolicies(List<PolicyDTO> policies) {
        this.policies = policies;
    }
}
