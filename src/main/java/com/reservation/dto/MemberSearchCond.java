package com.reservation.dto;

import lombok.Data;

@Data
public class MemberSearchCond {

    private String id;
    private String password;

    private String name;
    private String e_mail;
}
