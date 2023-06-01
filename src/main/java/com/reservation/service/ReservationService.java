package com.reservation.service;

import com.reservation.entity.Reservation;
import com.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> findAll(){
        List<Reservation> re = reservationRepository.findAll();
        Date a= re.get(1).getCreate_date();
        return reservationRepository.findAll();
    }





}
