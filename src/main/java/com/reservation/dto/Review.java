package com.reservation.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "review")
public class Review {
    @Id
    private int r_id;
    private int rs_id;
    private int m_id;
    private String contents;
    private String scope;
}
