package com.reservation.dto;

import com.reservation.constant.Role;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

//회원가입 폼 - 일반고객
@Data
public class MemberFormDto {

    private String id;
    private String password;
    private String name;
    private String number;
    private String e_mail;

    @Enumerated(EnumType.STRING)
    private Role role;
    private String status;
}
