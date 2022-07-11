package com.exam.prep.repository;

import com.exam.prep.model.entity.ProductEntity;
import com.exam.prep.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT SUM(p.price) FROM ProductEntity p")
    BigDecimal findTotalProductSum();

    List<ProductEntity> findAllByCategory_Name(CategoryNameEnum categoryNameEnum);


}
