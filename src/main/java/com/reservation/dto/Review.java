package com.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    private int r_id;
    private int rs_id;
    private int m_id;
    private String contents;
    private String scope;
}
