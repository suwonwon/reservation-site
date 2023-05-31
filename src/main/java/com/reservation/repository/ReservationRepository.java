package com.reservation.repository;

import com.reservation.dto.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Intger> {
}
