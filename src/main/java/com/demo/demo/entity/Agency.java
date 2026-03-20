package com.demo.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "agencies")
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    @JsonIgnore
    private Agency leader;

    @Column(name = "code")
    private String code;

    @Column(name = "khmer_identity_card")
    private String khmerIdentityCard;

    @Column(name = "agency_profile")
    private String agencyProfile;

    // @Column(name = "full_name")
    // private String fullName;

    // @Column(name = "full_name_translate")
    // private String fullNameTranslate;

    @Column(name = "full_name")
    @NotBlank(message = "Full name is required")
    @Size(max = 100, message = "Full name must be less than 100 characters")
    private String fullName;

    @Column(name = "full_name_translate")
    @NotBlank(message = "Full name translate is required")
    @Size(max = 100, message = "Full name translate must be less than 100 characters")
    private String fullNameTranslate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "phone_telegram")
    private String phoneTelegram;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getKhmerIdentityCard() {
        return khmerIdentityCard;
    }

    public void setKhmerIdentityCard(String khmerIdentityCard) {
        this.khmerIdentityCard = khmerIdentityCard;
    }

    public String getAgencyProfile() {
        return agencyProfile;
    }

    public void setAgencyProfile(String agencyProfile) {
        this.agencyProfile = agencyProfile;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullNameTranslate() {
        return fullNameTranslate;
    }

    public void setFullNameTranslate(String fullNameTranslate) {
        this.fullNameTranslate = fullNameTranslate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneTelegram() {
        return phoneTelegram;
    }

    public void setPhoneTelegram(String phoneTelegram) {
        this.phoneTelegram = phoneTelegram;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Agency getLeader() {
        return leader;
    }

    public void setLeader(Agency leader) {
        this.leader = leader;
    }

}
