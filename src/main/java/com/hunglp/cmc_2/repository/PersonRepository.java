package com.hunglp.cmc_2.repository;

import com.hunglp.cmc_2.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Page<Person> findByAge( Integer age , Pageable pageable);

    Page<Person> findByAddress(String address , Pageable pageable);

    Page<Person> findByName(String name, Pageable pageable);

    Page<Person> findAll( Pageable pageable);


}
