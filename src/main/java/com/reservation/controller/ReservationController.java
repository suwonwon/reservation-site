package com.reservation.controller;

import com.reservation.dto.Reservation;
import com.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @RequestMapping(value ="restaurant/reservation.html" ,method = RequestMethod.GET)
    public String Home(){
        System.out.println(reservationService.findAll());
        return "reservation";
    }





}
