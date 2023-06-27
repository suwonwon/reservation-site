package com.reservation.entity;

import com.reservation.constant.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int m_id;

    @OneToMany(mappedBy = "rs_member",cascade = CascadeType.ALL)
    @Nullable
    private List<Restaurant> m_rs;

    @OneToMany(mappedBy = "re_member")
    @Nullable
    private List<Reservation> m_re;

    @OneToMany(mappedBy = "m_id")
    @Nullable
    private List<Review> m_reviews;

    @OneToMany(mappedBy = "m_id")
    @Nullable
    private List<Star> m_star;

    @OneToMany(mappedBy = "m_id")
    @Nullable
    private List<Board> m_board;

    @OneToMany(mappedBy = "m_id")
    @Nullable
    private List<Comment> m_comment;




    private String id;
    private String password;
    private String name;
    private String number;
    private String e_mail;

    @Enumerated(EnumType.STRING)
    private Role role;
    private String status;

}
