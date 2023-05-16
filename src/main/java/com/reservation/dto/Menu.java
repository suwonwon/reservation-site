package com.reservation.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "menu")
public class Menu {
    @Id
    private int rs_id;
    private int menu_id;
    private String menu_img;
}
