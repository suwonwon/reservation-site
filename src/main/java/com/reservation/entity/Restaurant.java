package com.reservation.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rs_id;
    private int m_id;
    private String rs_name;
    private String address;
    private String rs_num;
    private String category;
    private String introduction;
    private String rs_info;

}
