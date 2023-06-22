package com.reservation.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.reservation.dto.findReDto;
import com.reservation.entity.QRestaurant;
import com.reservation.entity.QReservation;
import com.reservation.entity.Restaurant;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ReservationRepositoryImpl {

    JPAQueryFactory query;

    public ReservationRepositoryImpl (EntityManager em){
        this.query = new JPAQueryFactory(em);
    }

    private final QReservation qReservation = QReservation.reservation;
    private final QRestaurant qRestaurant = QRestaurant.restaurant;


    public List<findReDto> findReservations(int memberId) {
        List<findReDto> findDto = query.select(Projections.constructor(findReDto.class, qReservation.create_date, qReservation.people, qReservation.request, qRestaurant.rs_name))
                .from(qReservation)
                .join(qReservation.re_restaurant, qRestaurant)
                .where(qReservation.mId.eq(memberId)).orderBy(qReservation.create_date.desc()).fetch();
        return findDto;
    }


}
