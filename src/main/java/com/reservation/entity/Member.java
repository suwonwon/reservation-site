package com.reservation.entity;

import com.reservation.constant.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int m_id;

    @OneToMany(mappedBy = "rs_member")
    private List<Restaurant> m_rs;

    @OneToMany(mappedBy = "re_member")
    private List<Reservation> m_re;

    @OneToMany(mappedBy = "m_id")
    private List<Review> m_reviews;

    @OneToMany(mappedBy = "m_id")
    private List<Star> m_star;

    @OneToMany(mappedBy = "m_id")
    private List<Board> m_board;

    @OneToMany(mappedBy = "m_id")
    private List<Comment> m_comment;




    private String id;
    private String password;
    private String name;
    private String number;
    private String e_mail;
    private Role role;
    private String status;

}
