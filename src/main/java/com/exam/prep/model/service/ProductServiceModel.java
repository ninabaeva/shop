package com.exam.prep.model.service;

import com.exam.prep.model.entity.enums.CategoryNameEnum;

import java.math.BigDecimal;
import java.time.Instant;

public class ProductServiceModel {

    private Long id;
    private String name;
    private String description;
    private Instant neededBefore;
    private BigDecimal price;
    private CategoryNameEnum category;

    public ProductServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ProductServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Instant getNeededBefore() {
        return neededBefore;
    }

    public ProductServiceModel setNeededBefore(Instant neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ProductServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
