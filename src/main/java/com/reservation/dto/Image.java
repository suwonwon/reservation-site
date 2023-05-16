package com.reservation.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "image")
public class Image {
    @Id
    private int img_id;
    private int rs_id;
    private String img_ad;
}
