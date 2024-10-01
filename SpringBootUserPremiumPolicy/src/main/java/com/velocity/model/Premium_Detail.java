package com.velocity.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "premium_details")
public class Premium_Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long premiumDetailId;

    @Column(nullable = false)
    private String premiumType;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column
    private String currency;

    @ManyToOne
    @JoinColumn(name = "policyId")
    private Policy policy;

 // Getters and setters for all fields
    
	public Long getPremiumDetailId() {
		return premiumDetailId;
	}

	public void setPremiumDetailId(Long premiumDetailId) {
		this.premiumDetailId = premiumDetailId;
	}

	public String getPremiumType() {
		return premiumType;
	}

	public void setPremiumType(String premiumType) {
		this.premiumType = premiumType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

    
    
}
