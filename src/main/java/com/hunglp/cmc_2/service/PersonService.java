package com.hunglp.cmc_2.service;

import com.hunglp.cmc_2.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PersonService {

    Page<Person> findByAddress(String address , Pageable pageable);

    Page<Person> findByName(String name, Pageable pageable);

    Page<Person> findByAge(Integer age, Pageable pageable);

    Page<Person> findByProperties(String name, String address, Integer age, Pageable pageable);

    Page<Person> findAll(Pageable pageable);



}
