package com.example.jpa.relationship1.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Product")
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    private String name;

    public Product(Long id, Integer version, String name) {
        this.id = id;
        this.version = version;
        this.name = name;
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(int version, String name) {
        this.version = version;
        this.name = name;
    }
}
