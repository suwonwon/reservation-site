package com.reservation.repository;

import com.reservation.constant.Category;
import com.reservation.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>,
        QuerydslPredicateExecutor<Restaurant>, RestaurantRepositoryCustom {
    List<Restaurant> findByRsName(String rsName); //레스토랑명으로 데이터조회
    //List<Restaurant> findByRs_nameOrIntroduction(String rs_name, String introduction);
    List<Restaurant> findByAddress(String address);
    List<Restaurant> findByCategory(Category category);
}
