package com.jpa.finalapp.domain.service;

import com.jpa.finalapp.domain.dto.member.MemberJoinDto;
import com.jpa.finalapp.domain.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Override
    public void join(MemberJoinDto dto) {
        memberRepository.save(dto.toEntity());
    }

    @Override
    public Long login(String loginId, String password) {
        return null;
    }
}
