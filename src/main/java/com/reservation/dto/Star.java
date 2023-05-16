package com.reservation.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "star")
public class Star {
    @Id
    private int s_id;
    private int m_id;
    private int rs_id;

}
