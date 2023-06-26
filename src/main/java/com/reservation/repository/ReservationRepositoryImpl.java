package com.reservation.repository;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
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

    //식당조회
    public Restaurant findRestaurant(int rsId){
        Restaurant restaurant = query.select(qRestaurant).from(qRestaurant).where(qRestaurant.rsId.eq(rsId)).fetchOne();
        return restaurant;
    }


    //예약조회
    public List<findReDto> findReservations(int memberId) {
        List<findReDto> findDto = query.select(Projections.constructor(findReDto.class, qReservation.re_id,qReservation.create_date, qReservation.people, qReservation.request, qRestaurant.rs_name))
                .from(qReservation)
                .join(qReservation.re_restaurant, qRestaurant)
                .where(qReservation.mId.eq(memberId).and(qReservation.reservation_status.eq(0))).orderBy(qReservation.create_date.desc()).fetch();
        return findDto;
    }

    //예약취소
    public int statusReservation(int re_id){
        long updatedRows = query.update(qReservation)
                .set(qReservation.reservation_status, 1)
                .where(qReservation.re_id.eq(re_id))
                .execute();
        int result = updatedRows > 0 ? 1 : 0;
        return result;
    }


}
