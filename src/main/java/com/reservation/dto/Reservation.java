package com.reservation.dto;

import com.reservation.constant.ReservationStatus;
import com.reservation.entity.Member;
import com.reservation.entity.Restaurant;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class Reservation {

    private int re_id;
    private int m_id;
    private int rs_id;
    private String request;
    private String people;
    private Date create_date;
    private Date time;
    private String role;


}
