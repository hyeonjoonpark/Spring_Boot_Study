package com.jpa.finalapp.domain.service;

import com.jpa.finalapp.domain.dto.member.MemberDto;

public interface MemberService {
    void join(MemberDto dto);
    Long login(String loginId, String password);
}
