package com.reservation.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class ReservationTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int re_t_id;
    private int rs_id;
    private Date reservation;
}
