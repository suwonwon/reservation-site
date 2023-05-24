package com.reservation.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


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
