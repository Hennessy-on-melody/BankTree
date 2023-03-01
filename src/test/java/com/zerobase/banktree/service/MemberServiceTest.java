package com.zerobase.banktree.service;

import com.zerobase.banktree.domain.member.Member;
import com.zerobase.banktree.repository.MemberRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void joinServiceTest() throws Exception {
        //given
        Member member = new Member();
        member.setLoginId("aaa");

        //when
        Long saveId = memberService.joinService(member);

        //then

    }
}