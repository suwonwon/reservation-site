package com.reservation.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.reservation.entity.QReview;
import com.reservation.entity.Restaurant;
import com.reservation.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static com.reservation.entity.QReview.*;

@Repository
@Transactional
public class ReviewRepositoryImpl {
    private final JPAQueryFactory query;

    public ReviewRepositoryImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    public Page<Review> findAllByRestaurant(Restaurant restaurant, Pageable pageable) {

        QueryResults<Review> queryResults = query.select(review)
                .from(review)
                .where(review.rs_id.eq(restaurant))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        return new PageImpl<>(queryResults.getResults(), pageable, queryResults.getTotal());

    }

}
