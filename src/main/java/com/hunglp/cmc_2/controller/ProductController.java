package com.hunglp.cmc_2.controller;

import com.hunglp.cmc_2.model.Product;
import com.hunglp.cmc_2.model.Student;
import com.hunglp.cmc_2.repository.CustomPersonRepository;
import com.hunglp.cmc_2.repository.specification.Filter;
import com.hunglp.cmc_2.repository.specification.QueryOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private CustomPersonRepository customPersonRepository;

    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam Map<String, String> requestParams ) {


        List<Filter> filters = new ArrayList<>();
        requestParams.forEach((key, value) -> {
            if (Objects.nonNull(key) || Objects.nonNull(value)) {
                filters.add(Filter.builder()
                        .field(key)
                        .operator(QueryOperator.EQUALS)
                        .value(value)
                        .build());
            }
        });

        return customPersonRepository.getQueryResult(filters);
    }
}
