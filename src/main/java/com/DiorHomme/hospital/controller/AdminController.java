package com.DiorHomme.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.DiorHomme.hospital.service.AdminService;
import com.DiorHomme.hospital.model.AdminUser;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public List<AdminUser> getAllAdminUsers() {
        return adminService.getAllAdminUsers();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminUser createAdminUser(@RequestBody AdminUser adminUser) {
        return adminService.createAdminUser(adminUser);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdminUser(@PathVariable Long id) {
        if (!adminService.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin user not found");
        }
        adminService.deleteAdminUser(id);
    }
}
