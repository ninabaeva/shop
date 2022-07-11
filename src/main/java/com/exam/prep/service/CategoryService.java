package com.exam.prep.service;


import com.exam.prep.model.entity.CategoryEntity;
import com.exam.prep.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findByName(CategoryNameEnum categoryName);
}
