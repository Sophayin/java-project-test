package com.demo.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.dto.AssignPermissionRequest;
import com.demo.demo.entity.Permission;
import com.demo.demo.entity.Role;
import com.demo.demo.repository.RoleRepository;
import com.demo.demo.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/{roleId}/permissions")
    public Set<Permission> getRolePermissions(@PathVariable Long roleId) {

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        return role.getPermissions();
    }

    @PostMapping("/{roleId}/permissions")
    public Role assignPermissions(
            @PathVariable Long roleId,
            @RequestBody AssignPermissionRequest request) {

        return roleService.assignPermissions(roleId, request.getPermissionIds());
    }
}