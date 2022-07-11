package com.exam.prep.service.impl;

import com.exam.prep.model.entity.ProductEntity;
import com.exam.prep.model.entity.enums.CategoryNameEnum;
import com.exam.prep.model.service.ProductServiceModel;
import com.exam.prep.model.view.ProductViewModel;
import com.exam.prep.repository.ProductRepository;
import com.exam.prep.service.CategoryService;
import com.exam.prep.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;


    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        ProductEntity product = modelMapper.map(productServiceModel, ProductEntity.class);
        product
                .setCategory(categoryService.findByName(productServiceModel.getCategory()));

        productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalProductPrice() {
        return productRepository.findTotalProductSum();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategoryName(CategoryNameEnum categoryNameEnum) {
        return productRepository
                .findAllByCategory_Name(categoryNameEnum)
                .stream().map(productEntity -> modelMapper
                        .map(productEntity, ProductViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public void buyById(String id) {
        productRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
