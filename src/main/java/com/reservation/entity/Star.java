package com.reservation.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "star")
public class Star {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int s_id;
    private int m_id;
    private int rs_id;

}
