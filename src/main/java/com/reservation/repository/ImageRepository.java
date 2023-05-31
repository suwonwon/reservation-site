package com.reservation.repository;

import com.reservation.entity.Comment;
import com.reservation.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
