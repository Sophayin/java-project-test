package com.demo.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.demo.dto.AgencyLeaderInfo;
import com.demo.demo.entity.Agency;
import com.demo.demo.repository.AgencyRepository;

@Service
public class AgencyService {

    private final AgencyRepository agencyRepository;

    // ✅ REQUIRED constructor
    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    // GET ALL
    // public List<Agency> getAll() {
    // return agencyRepository.findAll();
    // }

    public Page<Agency> getAll(Pageable pageable) {
        return agencyRepository.findAll(pageable);
    }

    // GET BY ID
    public Agency getById(Long id) {
        return agencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agency not found"));
    }

    // CREATE
    public Agency create(Agency agency) {
        if (agency.getLeader() != null) {
            Agency leader = agencyRepository.findById(agency.getLeader().getId())
                    .orElseThrow(() -> new RuntimeException("Leader not found"));
            agency.setLeader(leader);
            agency.setCode(leader.getCode());
        }

        return agencyRepository.save(agency);
    }

    // UPDATE
    public Agency update(Long id, Agency request) {
        Agency agency = getById(id);

        agency.setFullName(request.getFullName());
        agency.setFullNameTranslate(request.getFullNameTranslate());
        agency.setLeader(request.getLeader()); // 🔥 THIS IS REQUIRED

        return agencyRepository.save(agency);
    }

    // DELETE
    public void delete(Long id) {
        agencyRepository.deleteById(id);
    }

    public List<Agency> getLeaderChain(Agency agency) {
        List<Agency> leaders = new ArrayList<>();

        Agency current = agency;

        while (current.getLeader() != null) {
            leaders.add(current.getLeader());
            current = current.getLeader();
        }

        return leaders;
    }

    public List<Agency> getAgencyHierarchy(Long id) {
        Agency agency = agencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agency not found"));
        return getLeaderChain(agency);
    }

    public AgencyLeaderInfo getLeaderInfo(Long id) {

        Agency agency = agencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agency not found"));

        Agency leader = agency.getLeader(); // direct

        if (leader == null) {
            return new AgencyLeaderInfo(null, null, null);
        }
        Agency indirectLeader = leader.getLeader(); // second level
        return new AgencyLeaderInfo(
                leader.getCode(),
                indirectLeader != null ? indirectLeader.getId() : null,
                indirectLeader != null ? indirectLeader.getCode() : null);
    }
}
