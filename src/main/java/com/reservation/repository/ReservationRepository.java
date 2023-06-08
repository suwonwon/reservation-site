package com.reservation.repository;

import com.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findAll();

    List<Reservation> findByRsid(int Rs_id);

    @Query("SELECT e.create_date FROM Reservation e WHERE e.create_date = :datetime AND e.rsid = :id")
    String executeQuery(@Param("datetime") Date datetime, @Param("id") int id);

}
