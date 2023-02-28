package com.zerobase.doibank.domain;

import jakarta.persistence.*;

import static jakarta.persistence.FetchType.*;

@Entity
public class Account {
    @Id @GeneratedValue
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    private String accountName;
    private int accountNumber;
    private long balance;

}
