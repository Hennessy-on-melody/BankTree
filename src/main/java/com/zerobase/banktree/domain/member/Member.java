package com.zerobase.banktree.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private Address address;


    @OneToMany(mappedBy = "member")
    private List<Account> accounts = new ArrayList<>();
}
