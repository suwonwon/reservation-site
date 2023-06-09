package com.reservation.dto;

import lombok.Data;

@Data
public class ReservationFormDto {

    private int id;
    private int year;
    private int month;
    private int day;
    private int hour;

    private String count;
    private String inputValue;
}
