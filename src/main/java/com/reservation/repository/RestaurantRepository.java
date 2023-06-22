package com.reservation.repository;

import com.reservation.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>,
        QuerydslPredicateExecutor<Restaurant>, RestaurantRepositoryCustom {
    List<Restaurant> findByRestaurantName(String restaurantName); //레스토랑명으로 데이터조회
    List<Restaurant> findByRestaurantNameOrIntroduction(String restaurantName, String introduction);
    List<Restaurant> findByRestaurantAddress(String restaurantAddress);
    List<Restaurant> findByRestaurantCategory(String restaurantCategory);
}
