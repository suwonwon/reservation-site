package com.reservation.dto;

import lombok.Data;

import javax.persistence.*;


@Data
public class Member {
    private String id;
    private String password;
    private String name;
    private String number;
    private String e_mail;
    private String nick_name;
    private String role;
    private String status;

}
