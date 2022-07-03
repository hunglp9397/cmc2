package com.hunglp.cmc_2.controller;


import com.hunglp.cmc_2.model.Person;
import com.hunglp.cmc_2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    @GetMapping("/persons")
    public ResponseEntity<?> getAllPerson(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "age") Integer age,
            @RequestParam(required = false, name = "address") String address,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {


        List<Order> orders = new ArrayList<>();

        // Sort multiple fields
        if (sort[0].contains(",")) {
            for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            orders.add(new Order(getSortDirection(sort[1]), sort[0]));
        }
        Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
        List<Person> personList = new ArrayList<>();

        try {

            Page<Person> pagePersons = personService.findByName(name, pagingSort);
//            Page<Person> pagePersons = personService.findByAge(age, pagingSort);
//            Page<Person> pagePersons = personService.findByAddress(address, pagingSort);

            personList = pagePersons.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("persons", personList);
            response.put("currentPage", pagePersons.getNumber());
            response.put("totalItems", pagePersons.getTotalElements());
            response.put("totalPages", pagePersons.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);


        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
