package com.hunglp.cmc_2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Distributor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne
    private Address address;


}
