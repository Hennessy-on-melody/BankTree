package com.zerobase.banktree.domain;

import com.zerobase.banktree.domain.member.Member;
import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
public class Transfer {
    @Id @GeneratedValue
    @Column(name = "TRANSFER_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
}
