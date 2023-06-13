package com.reservation.repository;

import com.reservation.dto.MainRestaurantDto;
import com.reservation.dto.RestaurantSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RestaurantRepositoryCustom {
    Page<MainRestaurantDto> getMainRestaurantPage(RestaurantSearchDto restaurantSearchDto, Pageable pageable);
}
