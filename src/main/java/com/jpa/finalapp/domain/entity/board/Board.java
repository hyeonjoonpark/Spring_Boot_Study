package com.jpa.finalapp.domain.entity.board;

import com.jpa.finalapp.domain.base.Period;
import com.jpa.finalapp.domain.entity.member.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@SequenceGenerator(name = "SEQ_BOARD_GENERATOR", sequenceName = "SEQ_BOARD")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @ToString
public class Board extends Period {
    @Id
    @GeneratedValue(generator = "SEQ_BOARD_GENERATOR")
    @Column(name = "board_id")
    private Long id;
    private String title;
    private String content;
    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY) // 반대쪽이 One일 때 default가 즉시로딩
    private Member member;

    @Builder
    public Board(Long id, String title, String content, Member member) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.member = member;
    }
}
