package com.reservation.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Data
public class Star {

    private int s_id;
    private int m_id;
    private int rs_id;

}
