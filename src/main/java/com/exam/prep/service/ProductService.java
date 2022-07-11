package com.exam.prep.service;

import com.exam.prep.model.entity.ProductEntity;
import com.exam.prep.model.entity.enums.CategoryNameEnum;
import com.exam.prep.model.service.ProductServiceModel;
import com.exam.prep.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalProductPrice();

    List<ProductViewModel> findAllProductsByCategoryName(CategoryNameEnum categoryNameEnum);

    void buyById(String id);

    void buyAll();
}
