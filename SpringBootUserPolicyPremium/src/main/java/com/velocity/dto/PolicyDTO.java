package com.velocity.dto;

import java.util.List;

public class PolicyDTO {
    private int id;
    private String policyNumber;
    private String policyType;
    private List<PremiumDTO> premiums;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public List<PremiumDTO> getPremiums() {
        return premiums;
    }

    public void setPremiums(List<PremiumDTO> premiums) {
        this.premiums = premiums;
    }
}

