package com.zerobase.banktree.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String loginId;
    private String name;
    private String email;
    private String password;
    private String mobile;

    @OneToMany(mappedBy = "member")
    private List<Account> accounts;

    @OneToMany(mappedBy = "member")
    private List<Transfer> transfers;
}
