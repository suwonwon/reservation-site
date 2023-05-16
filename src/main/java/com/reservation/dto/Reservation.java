package com.reservation.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "reservation")
public class Reservation {
    @Id
    private int re_id;
    private int rm_id;
    private int rs_id;
    private String request;

}
