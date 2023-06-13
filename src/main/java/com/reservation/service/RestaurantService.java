package com.reservation.service;

import com.reservation.entity.Restaurant;
import com.reservation.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    public Optional<Restaurant> findById(int id) {
        return restaurantRepository.findById(id);
    }
}
