package com.reservation.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional
@Repository
public class RestaurantRepositoryImpl {

    private final JPAQueryFactory query;

    public RestaurantRepositoryImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }


}
