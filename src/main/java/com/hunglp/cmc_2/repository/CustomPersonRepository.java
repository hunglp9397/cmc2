package com.hunglp.cmc_2.repository;

import com.hunglp.cmc_2.model.Category;
import com.hunglp.cmc_2.model.Product;
import com.hunglp.cmc_2.repository.specification.Filter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import static org.springframework.data.jpa.domain.Specification.where;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class CustomPersonRepository {


    @Autowired
    private ProductRepository productRepository;

    public List<Product> getQueryResult(List<Filter> filters){
        return filters.size() > 0 ? productRepository.findAll(getSpecificationFromFilter(filters)) : productRepository.findAll();
    }

    private Specification<Product> getSpecificationFromFilter(List<Filter> filters){
        Specification<Product> specification = where(createSpecification(filters.remove(0)));
        for(Filter filter : filters){
            specification = specification.and(createSpecification(filter));
        }
        return specification;
    }

    private Specification<Product> createSpecification(Filter filter) {
        switch (filter.getOperator()) {
            case EQUALS:
                return (root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(filter.getField()),
                                castToRequiredType(root.get(filter.getField()).getJavaType(), filter.getValue()));
            case NOT_EQ:
                return (root, query, criteriaBuilder) ->
                        criteriaBuilder.notEqual(root.get(filter.getField()),
                                castToRequiredType(root.get(filter.getField()).getJavaType(), filter.getValue()));
            case GREATER_THAN:
                return (root, query, criteriaBuilder) ->
                        criteriaBuilder.gt(root.get(filter.getField()),
                                (Number) castToRequiredType(root.get(filter.getField()).getJavaType(), filter.getValue()));
            case LESS_THAN:
                return (root, query, criteriaBuilder) ->
                        criteriaBuilder.lt(root.get(filter.getField()),
                                (Number) castToRequiredType(root.get(filter.getField()).getJavaType(), filter.getValue()));
            case LIKE:
                return (root, query, criteriaBuilder) ->
                        criteriaBuilder.like(root.get(filter.getField()), "%"+filter.getValue()+"%");
            case IN:
                return (root, query, criteriaBuilder) ->
                        criteriaBuilder.in(root.get(filter.getField()))
                                .value(castToRequiredType(root.get(filter.getField()).getJavaType(), filter.getValues()));

            default:
                throw new RuntimeException("Operation not supported yet");
        }

    }


    private Object castToRequiredType(Class fieldType, String value) {
        if (fieldType.isAssignableFrom(Double.class)) {
            return Double.valueOf(value);

        } else if (fieldType.isAssignableFrom(Integer.class)) {
            return Integer.valueOf(value);
        } else if (Enum.class.isAssignableFrom(fieldType)) {
            return Enum.valueOf(fieldType, value);
        }
        return null;
    }

    private Object castToRequiredType(Class fieldType, List<String> values){
        List<Object> lists = new ArrayList<>();
        for(String s : values){
            lists.add(castToRequiredType(fieldType, s));
        }
        return lists;
    }


}
