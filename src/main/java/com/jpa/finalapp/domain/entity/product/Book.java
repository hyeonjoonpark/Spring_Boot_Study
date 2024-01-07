package com.jpa.finalapp.domain.entity.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@SequenceGenerator(name = "SEQ_BOOK_GENERATOR", sequenceName = "SEQ_BOOK")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @ToString
@DiscriminatorValue("BOOK")
@PrimaryKeyJoinColumn(name = "book_id")
public class Book extends Product{
    private String author;
    private String publisher;

    @Builder
    public Book(Long id, String name, Integer price, Integer quantity, String author, String publisher) {
        super(id, name, price, quantity);
        this.author = author;
        this.publisher = publisher;
    }
}
