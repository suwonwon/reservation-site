package com.reservation.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Data
public class Restaurant {

    private int rs_id;
    private String rs_name;
    private String address;
    private String rs_num;
    private String category;
    private String introduction;
    private String rs_info;

}
