package com.reservation.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
public class Reservation {
    //private int re_id;
    //private int rm_id;
    //private int rs_id;
    private String request;

    private String people;
    //private Date create_date;


}
