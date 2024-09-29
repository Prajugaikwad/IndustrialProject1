package com.velocity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velocity.dto.PolicyDTO;
import com.velocity.dto.PremiumDTO;
import com.velocity.dto.UserDTO;
import com.velocity.model.User;
import com.velocity.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserWithPolicies(long userId) {
        return userRepository.findById(userId);
    }

    // Method to convert User to UserDTO
    public UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        List<PolicyDTO> policyDTOs = user.getPolicies().stream().map(policy -> {
            PolicyDTO policyDTO = new PolicyDTO();
            policyDTO.setId(policy.getId());
            policyDTO.setPolicyNumber(policy.getPolicyNumber());
            policyDTO.setPolicyType(policy.getPolicyType());

            List<PremiumDTO> premiumDTOs = policy.getPremiums().stream().map(premium -> {
                PremiumDTO premiumDTO = new PremiumDTO();
                premiumDTO.setId(premium.getId());
                premiumDTO.setAmount(premium.getAmount());
                premiumDTO.setPaymentDate(premium.getPaymentDate());
                return premiumDTO;
            }).toList();

            policyDTO.setPremiums(premiumDTOs);
            return policyDTO;
        }).toList();

        userDTO.setPolicies(policyDTOs);
        return userDTO;
    }
}
