package com.reservation.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int img_id;
    private int rs_id;
    private String img_role;
    private String img_ad;
}
