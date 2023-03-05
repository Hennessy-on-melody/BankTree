package com.zerobase.banktree.domain.member;

import com.zerobase.banktree.domain.account.Account;
import com.zerobase.banktree.domain.transfer.Transfer;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;
    private String mobile;
    private String password;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Account> accounts = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Transfer> transfers = new ArrayList<>();
}
