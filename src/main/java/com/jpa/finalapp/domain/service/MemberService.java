package com.jpa.finalapp.domain.service;

import com.jpa.finalapp.domain.dto.member.MemberJoinDto;

public interface MemberService {
    void join(MemberJoinDto dto);
    Long login(String loginId, String password);
}
