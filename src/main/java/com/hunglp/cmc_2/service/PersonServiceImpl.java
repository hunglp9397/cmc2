package com.hunglp.cmc_2.service;

import com.hunglp.cmc_2.model.Person;
import com.hunglp.cmc_2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    PersonRepository personRepository;


    @Override
    public Page<Person> findByAddress(String address, Pageable pageable) {
        return address == null ? personRepository.findAll(pageable) : personRepository.findByAddress(address, pageable);
    }

    @Override
    public Page<Person> findByName(String name, Pageable pageable) {
        return name == null ? personRepository.findAll(pageable) : personRepository.findByName(name, pageable);
    }

    @Override
    public Page<Person> findByAge(Integer age, Pageable pageable) {
        return age == null ? personRepository.findAll(pageable) : personRepository.findByAge(age, pageable);
    }


    @Override
    public Page<Person> findByProperties(String name, String address, Integer age, Pageable pageable) {
        return null;
    }


}
