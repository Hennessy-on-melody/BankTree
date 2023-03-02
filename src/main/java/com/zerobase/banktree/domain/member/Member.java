package com.zerobase.banktree.domain.member;

import com.zerobase.banktree.domain.Account;
import com.zerobase.banktree.domain.Transfer;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "LOGIN_ID", nullable = false, length = 20)
    private String loginId;

    @Column(name = "EMAIL", nullable = false, length = 255)
    private String email;

    @Column(name = "PASSWORD", nullable = false, length = 20)
    private String password;

    @Column(name = "MEMBER_STATUS")
    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    @Embedded
    private MemberInfo memberInfo;
    @OneToMany(mappedBy = "member")
    private List<Account> accounts;

    @OneToMany(mappedBy = "member")
    private List<Transfer> transfers;


    //==생성 메서드==//



}
