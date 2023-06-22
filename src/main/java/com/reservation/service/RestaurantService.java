package com.reservation.service;

import com.reservation.dto.MainRestaurantDto;
import com.reservation.dto.RestaurantSearchDto;
import com.reservation.entity.Restaurant;
import com.reservation.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
    public Optional<Restaurant> findById(int id) {
        return restaurantRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Page<MainRestaurantDto> getMainRestaurantPage(RestaurantSearchDto restaurantSearchDto,
                                                         Pageable pageable){
        return restaurantRepository.getMainRestaurantPage(restaurantSearchDto, pageable);

    }


}
