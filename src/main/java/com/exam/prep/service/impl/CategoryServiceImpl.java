package com.exam.prep.service.impl;

import com.exam.prep.model.entity.CategoryEntity;
import com.exam.prep.model.entity.enums.CategoryNameEnum;
import com.exam.prep.repository.CategoryRepository;
import com.exam.prep.service.CategoryService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void initCategories() {

        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values()).forEach(categoryNameEnum -> {
                CategoryEntity category = new CategoryEntity(categoryNameEnum, "Description for " + categoryNameEnum.name());
                categoryRepository.save(category);
            });
        }
    }

    @Override
    public CategoryEntity findByName(CategoryNameEnum categoryName) {
        return categoryRepository.findByName(categoryName).orElse(null);
    }
}
