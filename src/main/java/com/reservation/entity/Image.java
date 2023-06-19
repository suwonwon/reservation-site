package com.reservation.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int img_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant rs_id;
    private String img_role;
    private String img_ad;
    private String repImgYn; //대표이미지여부 추가

    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant; //매핑된 레스토랑 정보가 필요한 경우 데이터 조회하도록
}
