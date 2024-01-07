package com.jpa.finalapp.domain.entity.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@SequenceGenerator(name = "SEQ_COVER_GENERATOR", sequenceName = "SEQ_COVER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @ToString
@DiscriminatorValue("COVER")
@PrimaryKeyJoinColumn(name = "cover_id")
public class Cover extends Product {
    private String production;
    @Column(name = "cover_size")
    private Integer size;

    @Builder
    public Cover(Long id, String name, Integer price, Integer quantity, String production, Integer size) {
        super(id, name, price, quantity);
        this.production = production;
        this.size = size;
    }
}
