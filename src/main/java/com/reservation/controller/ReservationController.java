package com.reservation.controller;

import com.reservation.entity.Reservation;
import com.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @RequestMapping(value ="restaurant/{id}/reservation.html" ,method = RequestMethod.GET)
    public String Home(Model model,@PathVariable int id){
        List<HashMap<String, Integer>> rs_id=  reservationService.findByRsid(id);
        model.addAttribute("time" , rs_id);
        System.out.println(reservationService.findByRsid(id));
        return "reservation";
    }





}
