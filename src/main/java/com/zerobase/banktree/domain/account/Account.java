package com.zerobase.banktree.domain.account;

import com.zerobase.banktree.domain.member.Member;
import com.zerobase.banktree.domain.transfer.Transfer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    private int accountNumber;
    private int balance;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "account")
    private List<Transfer> transfers;


}