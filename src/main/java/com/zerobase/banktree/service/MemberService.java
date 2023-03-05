package com.zerobase.banktree.service;

import com.zerobase.banktree.domain.member.Member;
import com.zerobase.banktree.dto.MemberDto;
import com.zerobase.banktree.repository.MemberRepository;
import javax.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.zerobase.banktree.domain.member.MemberForm.Request;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MemberDto registerMember(Request request){
        validateDuplicateMember(request.getEmail());

        return MemberDto.fromEntity(memberRepository.save(Member.builder()
                        .email(request.getEmail())
                        .name(request.getName())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .mobile(request.getMobile())
                .build()));
    }

    private void validateDuplicateMember(@NotBlank String email) {
        if (memberRepository.findByEmail(email).isPresent()){
            throw new IllegalStateException("이미 가입한 회원입니다.");
        }
    }
}
