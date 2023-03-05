package com.zerobase.banktree.dto;


import com.zerobase.banktree.domain.member.Address;
import com.zerobase.banktree.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberDto {
    private String email;
    private String name;
    private String password;
    private String mobile;
    private Address address;

    public static MemberDto fromEntity(Member member) {
        return MemberDto.builder()
                .email(member.getEmail())
                .name(member.getName())
                .address(member.getAddress())
                .build();
    }
}
