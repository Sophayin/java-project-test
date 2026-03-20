package com.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.demo.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}