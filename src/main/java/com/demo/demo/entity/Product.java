
package com.demo.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String code;

    private String title;

    @Column(name = "title_translate")
    private String titleTranslate;

    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "year_of_manufacture")
    private Integer yearOfManufacture;

    private String condition;

    private Double discount;

    @Column(name = "discount_type")
    private String discountType;

    private String description;

    private Double price;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "shop_id")
    private Long shopId;

    private Integer status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private String name;

    private String type;

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleTranslate() {
        return titleTranslate;
    }

    public Category getCategory() {
        return category;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public String getCondition() {
        return condition;
    }

    public Double getDiscount() {
        return discount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getItemType() {
        return itemType;
    }

    public Long getShopId() {
        return shopId;
    }

    public Integer getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    // ===== SETTERS =====

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitleTranslate(String titleTranslate) {
        this.titleTranslate = titleTranslate;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public void setYearOfManufacture(Integer yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
