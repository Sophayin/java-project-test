package com.demo.demo.dto;

import com.demo.demo.entity.Agency;

public class AgencyLeaderInfo {

    private String leaderCode;
    private Long indirectLeaderId;
    private String indirectLeaderCode;
    private Agency leader;

    // ✅ default constructor (REQUIRED)
    public AgencyLeaderInfo() {
    }

    // constructor
    public AgencyLeaderInfo(String leaderCode, Long indirectLeaderId, String indirectLeaderCode) {
        this.leaderCode = leaderCode;
        this.indirectLeaderId = indirectLeaderId;
        this.indirectLeaderCode = indirectLeaderCode;
    }

    // getters
    public String getLeaderCode() {
        return leaderCode;
    }

    public Long getIndirectLeaderId() {
        return indirectLeaderId;
    }

    public String getIndirectLeaderCode() {
        return indirectLeaderCode;
    }

    public Agency getLeader() {
        return leader;
    }

    // setters
    public void setLeaderCode(String leaderCode) {
        this.leaderCode = leaderCode;
    }

    public void setIndirectLeaderId(Long indirectLeaderId) {
        this.indirectLeaderId = indirectLeaderId;
    }

    public void setIndirectLeaderCode(String indirectLeaderCode) {
        this.indirectLeaderCode = indirectLeaderCode;
    }

    public void setLeader(Agency leader) {
        this.leader = leader;
    }

    // ✅ FIXED mapping method
    public static AgencyLeaderInfo from(Agency agency) {

        AgencyLeaderInfo dto = new AgencyLeaderInfo();

        dto.setLeader(agency); // ✔ this matches your field
        dto.setLeaderCode(agency.getCode()); // adjust if your field name is different

        return dto;
    }
}