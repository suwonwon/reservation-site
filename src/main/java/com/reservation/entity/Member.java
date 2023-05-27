package com.reservation.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int m_id;
    private String id;
    private String password;
    private String name;
    private String number;
    private String e_mail;
    private String role;
    private String status;

}
