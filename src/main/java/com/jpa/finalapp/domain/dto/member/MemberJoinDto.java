package com.jpa.finalapp.domain.dto.member;

import com.jpa.finalapp.domain.embedded.member.MemberAddress;
import com.jpa.finalapp.domain.entity.member.Member;
import com.jpa.finalapp.types.memberType.MemberGender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class MemberJoinDto {
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String birth;
    private String phoneNumber;
    private String memberGender;
    private String address;
    private String addressDetail;
    private String zipcode;

    public Member toEntity() {
        MemberAddress memberAddress = new MemberAddress(address, addressDetail, zipcode);
        MemberGender gender = MemberGender.valueOf(this.memberGender);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(birth, formatter);

        return Member.builder()
                .loginId(loginId)
                .password(password)
                .name(name)
                .memberGender(gender)
                .memberAddress(memberAddress)
                .phoneNumber(phoneNumber)
                .birth(birthDate)
                .build();
    }

    // Entity -> DTO
    // Static factory method
    public static MemberJoinDto from(Member member) {
        MemberJoinDto dto = new MemberJoinDto();
        dto.setLoginId(member.getLoginId());
        dto.setPassword(member.getPassword());
        dto.setName(member.getName());
        dto.setBirth(member.getBirth().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        dto.setMemberGender(member.getMemberGender().name());
        dto.setAddress(member.getMemberAddress().getAddress());
        dto.setAddress(member.getMemberAddress().getAddressDetail());
        dto.setAddress(member.getMemberAddress().getZipcode());

        return dto;
    }
}
