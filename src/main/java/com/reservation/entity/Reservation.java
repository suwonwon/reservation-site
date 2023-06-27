package com.reservation.entity;

import com.reservation.constant.ReservationStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int re_id;
    private int m_id;
    @Column(name = "rs_id")
    private int rsid;

    @ManyToOne(fetch = FetchType.EAGER)
    private Member re_member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant re_restaurant;

    private String request;

    private String people;
    private Date create_date;
    private int reservation_status;


}
