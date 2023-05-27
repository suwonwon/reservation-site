package com.reservation.dto;

import lombok.Data;


@Data
public class RestaurantDto {
    //private int rs_id;
    private String rs_name;
    private String address;
    private String rs_num;
    private String category;
    private String introduction;
    private String rs_info;

}
