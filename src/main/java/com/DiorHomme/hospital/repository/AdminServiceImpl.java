package com.DiorHomme.hospital.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DiorHomme.hospital.model.AdminUser;

@Service
public class AdminServiceImpl {

    @Autowired
    private AdminUserRepository adminUserRepository;

    public List<AdminUser> getAllAdminUsers() {
        return adminUserRepository.findAll();
    }

    public AdminUser createAdminUser(AdminUser adminUser) {
        return adminUserRepository.save(adminUser);
    }

    public boolean existsById(Long id) {
        return adminUserRepository.existsById(id);
    }

    public void deleteAdminUser(Long id) {
        adminUserRepository.deleteById(id);
    }
}
