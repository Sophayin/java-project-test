package com.demo.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.entity.Agency;
import com.demo.demo.service.AgencyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/agencies")
public class AgencyController {

    private final AgencyService agencyService;

    // ✅ REQUIRED constructor
    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    // GET ALL
    // @GetMapping
    // public List<Agency> getAll() {
    // return agencyService.getAll();
    // }

    @GetMapping
    public Page<Agency> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return agencyService.getAll(pageable);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Agency getById(@PathVariable Long id) {
        return agencyService.getById(id);
    }

    // CREATE
    @PostMapping
    public Agency create(@Valid @RequestBody Agency agency) {
        try {
            System.out.println("Incoming: " + agency.getFullName());
            return agencyService.create(agency);
        } catch (Exception e) {
            e.printStackTrace(); // 🔥 THIS WILL SHOW REAL ERROR
            throw e;
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public Agency update(@PathVariable Long id, @RequestBody Agency agency) {
        return agencyService.update(id, agency);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        agencyService.delete(id);
        return "Deleted successfully";
    }

    @GetMapping("/{id}/leaders")
    public List<Agency> getLeaders(@PathVariable Long id) {
        return agencyService.getAgencyHierarchy(id);
    }

}
