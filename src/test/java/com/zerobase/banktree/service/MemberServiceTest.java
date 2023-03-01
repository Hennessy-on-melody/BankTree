package com.zerobase.banktree.service;

import com.zerobase.banktree.domain.member.Member;
import com.zerobase.banktree.repository.MemberRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@RunWith(SpringRunner.class)
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
        Assert.assertSame(member.getLoginId(), "aaa");

    }
}