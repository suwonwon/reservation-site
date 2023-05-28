package com.reservation.dto;

import lombok.Data;

import java.util.Date;


@Data
public class BoardFormDto {

    private int p_id;
    private int m_id;
    private String title;
    private String contents;
    private Date create_date;
    private Date modify_date;
    private Date delete_date;
    private Date is_delete;

}
