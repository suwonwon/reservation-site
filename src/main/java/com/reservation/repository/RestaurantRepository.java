package com.reservation.repository;

import com.reservation.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
//    Optional<Restaurant> findByRs_name(String rs_name);
}
