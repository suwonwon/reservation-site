package com.reservation.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "restaurant")
public class Restaurant {
    @Id
    private int rs_id;
    private String rs_name;
    private String address;
    private String rs_num;
    private String category;
    private String rs_info;

}
