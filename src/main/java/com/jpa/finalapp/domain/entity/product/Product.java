package com.jpa.finalapp.domain.entity.product;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@SequenceGenerator(name = "SEQ_PRODUCT_GENERATOR", sequenceName = "SEQ_PRODUCT")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @ToString
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
public class Product {
    @Id
    @GeneratedValue(generator = "SEQ_PRODUCT_GENERATOR")
    @Column(name = "product_id")
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;

    public Product(Long id, String name, Integer price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
