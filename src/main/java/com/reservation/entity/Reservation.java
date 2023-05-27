package com.reservation.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int re_id;
    private int rm_id;
    private int rs_id;
    private String request;

    private String people;
    private Date create_date;
    private Date time;
    private String role;


}
