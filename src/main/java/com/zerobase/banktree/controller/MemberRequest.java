package com.zerobase.banktree.controller;

import com.zerobase.banktree.domain.member.Address;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MemberRequest {
    @NotBlank(message = "이메일은 필수 입력값입니다.")
    private String email;
    @NotBlank(message = "이름은 필수 입력값입니다.")
    private String name;
    private String mobile;
    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    private String password;
    private Address address;
}
