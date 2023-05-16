package com.reservation.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Data
@Table(name = "reservation_time")
public class ReservationTime {
    @Id
    private int re_t_id;
    private int rs_id;
    private Date reservation;
}
