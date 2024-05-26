package com.IvAssessment.IvCodeAssignment;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateUser(String userId, String password) {
        return userId.equalsIgnoreCase("admin")
                && password.equalsIgnoreCase("admin");
    }

}