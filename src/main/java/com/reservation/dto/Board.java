package com.reservation.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "board")
public class Board {
    @Id
    private int p_id;
    private int m_id;
    private String title;
    private String contents;
    private Date create_date;
    private Date modify_date;
    private Date delete_date;
    private Date is_delete;

}
