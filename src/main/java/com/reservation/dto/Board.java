package com.reservation.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

import java.util.Date;


@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int p_id;
    private int m_id;
    private String title;
    private String contents;
    private Date create_date;
    private Date modify_date;
    private Date delete_date;
    private Date is_delete;

}
