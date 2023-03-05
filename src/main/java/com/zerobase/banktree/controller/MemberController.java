package com.zerobase.banktree.controller;

import com.zerobase.banktree.domain.member.MemberForm;
import com.zerobase.banktree.dto.MemberDto;
import com.zerobase.banktree.repository.MemberRepository;
import com.zerobase.banktree.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.zerobase.banktree.domain.member.MemberForm.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public Response createMember(@RequestBody @Valid Request request){
        MemberDto memberDto = memberService.registerMember(request);
        return Response.from(memberDto);
    }
}
