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

    @ManyToOne(fetch = FetchType.LAZY)
    private Member re_member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant re_restaurant;

    private String request;

    private String people;
    private Date create_date;
    private ReservationStatus reservationStatus;


}
