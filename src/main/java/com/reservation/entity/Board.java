package com.reservation.entity;

import com.reservation.constant.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int p_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member m_id;
    private String title;
    private String contents;
    private Role role;
    private Date create_date;
    private Date modify_date;
    private Date delete_date;
    private Date is_delete;


}
