package com.reservation.dto;

import com.querydsl.core.Tuple;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class findReDto {

    int re_id;
    Date create_date;
    String people;
    String request;
    String  rs_name;
}
