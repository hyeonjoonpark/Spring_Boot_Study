package com.jpa.finalapp.domain.entity.product;

import com.jpa.finalapp.types.productType.StandMaterials;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@SequenceGenerator(name = "SEQ_STAND_GENERATOR", sequenceName = "SEQ_STAND")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @ToString
@DiscriminatorValue("STAND")
@PrimaryKeyJoinColumn(name = "stand_id")
public class Stand extends Product{
    private String production;
    @Enumerated(EnumType.STRING)
    private StandMaterials materials;

    @Builder
    public Stand(Long id, String name, Integer price, Integer quantity, String production, StandMaterials materials) {
        super(id, name, price, quantity);
        this.production = production;
        this.materials = materials;
    }
}
