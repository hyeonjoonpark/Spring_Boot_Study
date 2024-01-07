package com.jpa.finalapp.domain.entity.order;


import com.jpa.finalapp.domain.base.Period;
import com.jpa.finalapp.domain.entity.member.Member;
import com.jpa.finalapp.types.orderStatusType.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table
@SequenceGenerator(name = "SEQ_ORDER_GENERATOR", sequenceName = "SEQ_ORDER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @ToString
@DynamicInsert
public class Order extends Period {
    @Id
    @GeneratedValue(generator = "SEQ_ORDER_GENERATOR")
    @Column(name = "order_id")
    private Long id;
    @Enumerated(EnumType.STRING) @ColumnDefault("'WAIT'")
    private OrderStatus orderStatus;
    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Builder
    public Order(Long id, OrderStatus orderStatus, Member member) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.member = member;
    }
}
