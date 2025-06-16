package com.DiorHomme.hospital.service;

import com.DiorHomme.hospital.model.AdminUser;
import com.DiorHomme.hospital.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String login(String username, String password) {
        Optional<AdminUser> user = adminUserRepository.findByUsername(username);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return generateToken(username);
        }
        return null;
    }

    public boolean register(String username, String password, String email, String name) {
        if (adminUserRepository.findByUsername(username).isPresent()) {
            return false;
        }
        AdminUser user = new AdminUser();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setName(name);
        adminUserRepository.save(user);
        return true;
    }

    public String generateToken(String username) {
        // Implement your JWT token generation logic here
        // This is a placeholder implementation
        return "Bearer " + username + "-token";
    }
}
