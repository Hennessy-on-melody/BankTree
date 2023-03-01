package com.zerobase.banktree.service;

import com.zerobase.banktree.domain.member.Member;
import com.zerobase.banktree.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    /**
     * 회원가입
     */
    @Transactional
    public Long joinService(Member member){
        validateDuplicateEmail(member);
        validateDuplicateLoginId(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateLoginId(Member member) {
        List<Member> findMembers = memberRepository.findMemberByLoginId(member.getLoginId());
        if (!findMembers.isEmpty()){
            throw new IllegalStateException("해당 아이디는 사용할 수 없습니다.");
        }
    }

    private void validateDuplicateEmail(Member member) {
        List<Member> findMembers = memberRepository.findMemberByEmail(member.getEmail());
        if (!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재 하는 이메일입니다.");
        }
    }
}
