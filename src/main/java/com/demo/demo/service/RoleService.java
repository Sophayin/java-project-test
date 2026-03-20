package com.demo.demo.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.demo.entity.Permission;
import com.demo.demo.entity.Role;
import com.demo.demo.repository.PermissionRepository;
import com.demo.demo.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    public Role assignPermissions(Long roleId, List<Long> permissionIds) {

        // 1. find role
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        // 2. get permissions from DB
        List<Permission> permissions = permissionRepository.findAllById(permissionIds);

        // 3. assign permissions
        role.setPermissions(new HashSet<>(permissions));

        // 4. save (IMPORTANT 🔥)
        return roleRepository.save(role);
    }
}