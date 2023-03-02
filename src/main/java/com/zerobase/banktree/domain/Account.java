package com.zerobase.banktree.domain;

import com.zerobase.banktree.domain.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@Setter
public class Account {
    @Id @GeneratedValue
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name = "ACCOUNT_NUMBER", nullable = false, length = 12)
    private int accountNumber;

    @Column(name = "BALANCE")
    private long balance;


    //==생성 메서드==//
    public static Account createAccount (Member member){
        //계좌 생성
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            sb.append((int)((Math.random() * 10000) % 10));
        }

        Account account = new Account();
        account.setMember(member);
        account.setAccountNumber(Integer.);
    }

}
