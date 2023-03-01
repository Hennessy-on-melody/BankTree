package com.zerobase.banktree.repository;


import com.zerobase.banktree.domain.member.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;


    public void save(Member member) {
        em.persist(member);
    }

    public List<Member> findMemberByEmail(String email) {
        return em.createQuery("select m from Member m where m.email = :email",
                        Member.class)
                .setParameter("email", email)
                .getResultList();
    }

    public List<Member> findMemberByLoginId(String loginId) {
        return em.createQuery("select m from Member m where m.loginId = :loginId"
                , Member.class)
                .setParameter("loginId", loginId)
                .getResultList();
    }

}
