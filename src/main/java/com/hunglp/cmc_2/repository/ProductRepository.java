package com.hunglp.cmc_2.repository;

import com.hunglp.cmc_2.model.Category;
import com.hunglp.cmc_2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findAllByNameLike(String name);

    List<Product> findAllByNameAndPriceLessThanEqual(String name, Double price);

    List<Product> findAlByCategoryInAndPriceLessThanEqual(List<Category> categories, Double price);

    List<Product> findAllByCategoryInAndPriceBetween(List<Category>categories,Double bottom, Double top);

    List<Product> findAllByNameLikeAndCategoryIn(String name, List<Category> categories);

    List<Product> findAllByNameLikeAndCategoryInAndPriceBetween(String name, List<Category> categories,
                                                                 Double bottom, Double top);





}
