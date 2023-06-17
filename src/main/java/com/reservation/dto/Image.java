package com.reservation.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    private int img_id;
    private int rs_id;
    private String img_ad;
    private String repImgYn; //대표이미지 여부
}
