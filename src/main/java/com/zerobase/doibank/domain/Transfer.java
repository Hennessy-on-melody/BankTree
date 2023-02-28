package com.zerobase.doibank.domain;

import jakarta.persistence.*;

import static jakarta.persistence.FetchType.*;

@Entity
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
