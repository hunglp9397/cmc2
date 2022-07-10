package com.hunglp.cmc_2.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;

@Entity
@Data
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double price;

    @ManyToOne
    private Address address;

    @Embedded
    private Dimension dimension;


    @Embeddable
    public static class Dimension{
        private Double height;

        private Double width;
    }

    @Enumerated(EnumType.STRING)
    private Category category;
}
