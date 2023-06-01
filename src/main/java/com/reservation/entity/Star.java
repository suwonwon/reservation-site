package com.reservation.entity;

import com.reservation.constant.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "star")
public class Star {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int s_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member m_id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant rs_id;
    private Boolean isStar;

}
