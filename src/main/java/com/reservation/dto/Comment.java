package com.reservation.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;
@Data
public class Comment {

    //private int c_id;
    //private int m_id;
    //private int p_id;
    private String comment;
    //private Date create_date;
    //private Date modify_date;
    //private Date delete_date;
    //private Date is_delete;

}


