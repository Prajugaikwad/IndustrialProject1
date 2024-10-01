package com.velocity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velocity.model.Policy;
import com.velocity.model.Premium_Detail;
import com.velocity.model.User;
import com.velocity.repository.PolicyRepository;
import com.velocity.repository.PremiumRepository;
import com.velocity.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private PremiumRepository premiumDetailRepository;

    @Transactional
    public User createUser(User user) {
        // Save the user first
        user = userRepository.save(user);

        // Save each policy associated with the user
        for (Policy policy : user.getPolicies()) {
            policy.setUser(user); // Set the user reference for each policy
            policyRepository.save(policy);

            // Save each premium detail associated with the policy
            for (Premium_Detail detail : policy.getPremiumDetails()) {
                detail.setPolicy(policy); // Set the policy reference for each premium detail
                premiumDetailRepository.save(detail); 
            }
        }

        return user;
    }
}