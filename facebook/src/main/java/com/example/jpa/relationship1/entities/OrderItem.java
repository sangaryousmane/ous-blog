package com.example.jpa.relationship1.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "OrderItem")
@Setter
@Getter
@NoArgsConstructor
public class OrderItem {

    @Id
    private Long id;
    @Version
    private int version;
    private double quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    private OrderItem(Long id, Integer version, double quantity) {
        this.id = id;
        this.version = version;
        this.quantity = quantity;
    }
}
