package com.reservation.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class MainRestaurantDto { //메인페이지에서 레스토랑 목록 보여주기 위해 만듬

    private int rs_id;
    private String rs_name;
    private String introduction;
    //식당 이미지

    @QueryProjection
    public MainRestaurantDto(int rs_id, String rs_name, String introduction //,식당이미지
    ){
        this.rs_id = rs_id;
        this.rs_name = rs_name;
        this.introduction = introduction;
        //식당이미지
    }

}
