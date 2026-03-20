package com.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.demo.entity.Agency;

public interface AgencyRepository extends JpaRepository<Agency, Long> {
}