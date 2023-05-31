package com.reservation.repository;

import com.reservation.entity.Review;
import com.reservation.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepository extends JpaRepository<Star, Integer> {
}
