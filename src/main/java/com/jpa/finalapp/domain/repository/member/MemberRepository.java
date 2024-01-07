package com.jpa.finalapp.domain.repository.member;

import com.jpa.finalapp.domain.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 회원가입은 JpaRepository에서 제공해주는 save() 사용

    // 로그인
    @Query("select m.id from Member m where m.loginId = :loginId and m.password = :password")
    Optional<Long> findIdByLoginIdAndPassword(
            @Param("loginId") String loginId,
          @Param("password") String password
    );
}
