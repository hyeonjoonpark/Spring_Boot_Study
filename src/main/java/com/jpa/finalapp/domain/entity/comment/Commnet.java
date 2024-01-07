package com.jpa.finalapp.domain.entity.comment;

import com.jpa.finalapp.domain.base.Period;
import com.jpa.finalapp.domain.entity.board.Board;
import com.jpa.finalapp.domain.entity.member.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@SequenceGenerator(name = "SEQ_COMMENT_GENERATOR", sequenceName = "SEQ_COMMENT")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @ToString
public class Commnet extends Period {
    @Id
    @GeneratedValue(generator = "SEQ_COMMENT_GENERATOR")
    @Column(name = "comment_id")
    private Long id;
    String content;
    @JoinColumn(name = "board_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Builder
    public Commnet(Long id, String content, Board board, Member member) {
        this.id = id;
        this.content = content;
        this.board = board;
        this.member = member;
    }
}
