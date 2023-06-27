package com.reservation.security;

import com.reservation.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class AccountContext extends User {
    private final Member member;

    public AccountContext(Member member, Collection<? extends GrantedAuthority> authorities) {
        super(member.getId(), member.getPassword(), authorities);
        this.member = member;
    }

    public Member getMember() {
        return member;
    }
}
