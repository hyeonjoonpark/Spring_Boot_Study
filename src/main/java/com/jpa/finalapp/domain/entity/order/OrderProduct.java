package com.jpa.finalapp.domain.entity.order;

import com.jpa.finalapp.domain.base.Period;
import com.jpa.finalapp.domain.entity.product.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table
@SequenceGenerator(name = "SEQ_ORDER_PRODUCT_GENERATOR", sequenceName = "SEQ_ORDER_PRODUCT")
@Getter @ToString @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderProduct extends Period {
    @Id
    @GeneratedValue(generator = "SEQ_ORDER_PRODUCT_GENERATOR")
    @Column(name = "order_product_id")
    private Long id;
    private Integer price;
    private Integer productCount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public OrderProduct(Long id, Integer price, Integer productCount, Order order, Product product) {
        this.id = id;
        this.price = price;
        this.productCount = productCount;
        this.order = order;
        this.product = product;
    }
}
