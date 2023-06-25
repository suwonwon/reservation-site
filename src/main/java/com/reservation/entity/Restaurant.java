package com.reservation.entity;

import com.reservation.constant.Category;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rs_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Member rs_member;

    @OneToMany(mappedBy = "re_restaurant")
    private List<Reservation> rs_reservation;

    @OneToMany(mappedBy = "rs_id")
    private List<Review> rs_review;

    @OneToMany(mappedBy = "rs_id")
    private List<Star> rs_star;

    @OneToMany(mappedBy = "rs_id")
    private List<Image> rs_img;


    private String rs_name;
    private String address;
    private String rs_num;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String introduction;
    private String rs_info;

}
