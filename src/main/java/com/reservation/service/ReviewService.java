package com.reservation.service;

import com.reservation.entity.Restaurant;
import com.reservation.entity.Review;
import com.reservation.repository.BoardRepository;
import com.reservation.repository.RestaurantRepository;
import com.reservation.repository.ReviewRepository;
import com.reservation.repository.ReviewRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewRepositoryImpl reviewRepositoryImpl;

    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    public Page<Review> getAllReviewsForRestaurant(Restaurant restaurant, Pageable pageable) {

        return reviewRepositoryImpl.findAllByRestaurant(restaurant, pageable);
    }




}
