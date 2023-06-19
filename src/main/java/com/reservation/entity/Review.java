package com.reservation.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int r_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant rs_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member m_id;
    private String contents;
    private int scope;
}
